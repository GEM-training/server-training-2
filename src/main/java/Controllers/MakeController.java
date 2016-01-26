package Controllers;

import Dao.MakeDao;
import Dao.StaffDao;
import Models.Make;
import Models.Product;
import Models.ResponseObject;
import Services.MakeServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
@RestController
@RequestMapping("/make")
@Transactional
public class MakeController {
    @Autowired
    MakeServices makeServices;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getListMakes() {
        try {
            List<Make> makes = makeServices.getAllMakes();
            return new ResponseObject(true, Constants.HTTP.SUCCESS, makes);
        } catch (Exception e) {
            return new ResponseObject(true, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject addOneMake(@RequestBody Make make) {
        try {
            Integer makeId = makeServices.save(make);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, makeId);
        } catch (Exception e) {
            return new ResponseObject(true, e.getCause().toString(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteMake(@RequestParam("makeId") Integer makeId) {
        try {
            makeServices.delete(makeId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, null);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-products")
    public @ResponseBody ResponseObject getProducts(@RequestParam("makeId") Integer makeId) {
        try{
            List<Product> products = new ArrayList<Product>(makeServices.getProducts(makeId));
            return new ResponseObject(true,Constants.HTTP.SUCCESS,products);
        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }
    }
}
