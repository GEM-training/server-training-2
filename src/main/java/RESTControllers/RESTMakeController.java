package RESTControllers;

import Models.Make;
import Models.Product;
import Models.ResponseObject;
import Services.MakeServices;
import Utils.CommonUtils;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
@RestController
@RequestMapping("/api/make")

public class RESTMakeController {
    @Autowired
    MakeServices makeServices;

    @RequestMapping(value = "/get-makes", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getMakes(@RequestParam(value = "start", required = false) Integer start) {
        List<Make> makes;
        try {
            if (start == null) {
                makes = makeServices.getAllMakes();
            } else {
                makes = makeServices.getMakes(start);
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, makes);
        } catch (Exception e) {
            return new ResponseObject(true, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject save(@RequestBody Make make) {
        Set<ConstraintViolation<Make>> constraintViolations = CommonUtils.getValidator().validate(make);
        if (constraintViolations.size() > 0) {
            return new ResponseObject(false, constraintViolations.iterator().next().getMessage(), null);
        }
        try {
            Integer makeId = makeServices.save(make);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, makeId);
        } catch (Exception e) {
            return new ResponseObject(false, e.getCause().toString(), null);
        }
    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody Make make) {
        try {
            makeServices.saveOrUpdate(make);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, null);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("makeId") Integer makeId) {
        try {
            makeServices.delete(makeId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, null);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-products")
    public
    @ResponseBody
    ResponseObject getProducts(@RequestParam("makeId") Integer makeId) {
        try {
            List<Product> products = new ArrayList<Product>(makeServices.getProducts(makeId));
            return new ResponseObject(true, Constants.HTTP.SUCCESS, products);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}
