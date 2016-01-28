package RESTControllers;

import Models.Dealer;
import Models.Product;
import Models.ResponseObject;
import Services.MakeServices;
import Services.ProductServices;
import Utils.CommonUtils;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
@RestController
@RequestMapping("/api/product")

public class RESTProductController {
    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteProduct(@RequestParam("productId") Integer productId) {
        try {
            productServices.delete(productId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, null);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-products")
    public
    @ResponseBody
    ResponseObject getProducts(@RequestParam(value = "start", required = false) Integer start) {
        List<Product> products;
        try {
            if (start != null) {
                products = productServices.getProducts(start);

            } else {
                products = productServices.getAllProducts();
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, products);

        } catch (Exception e) {
            e.getStackTrace();
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject addProduct(@RequestBody Product product) {
        Set<ConstraintViolation<Product>> constraintViolations = CommonUtils.getValidator().validate(product);
        if (constraintViolations.size() > 0) {
            return new ResponseObject(false, constraintViolations.iterator().next().getMessage(), null);
        }
        try {
            Integer productId = productServices.save(product);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, productId);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject saveProduct(@RequestBody Product product) {
        try {
            productServices.saveOrUpdate(product);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, null);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/get-parts")
    public
    @ResponseBody
    ResponseObject getListParts(@RequestParam("productId") Integer productId) {
        try {
            List<Product> listParts = new ArrayList<Product>();
            listParts.addAll(productServices.getParts(productId));
            return new ResponseObject(true, Constants.HTTP.SUCCESS, listParts);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject getProduct(@RequestParam("productId") Integer productId) {
        try {
            Product product = productServices.findById(productId);
            return new ResponseObject(true, "", product);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-dealers")
    public
    @ResponseBody
    ResponseObject getDealers(@RequestParam("productId") Integer productId) {
        try {
            List<Dealer> dealers = new ArrayList<Dealer>();
            dealers.addAll(productServices.getDealers(productId));
            return new ResponseObject(true, Constants.HTTP.SUCCESS, dealers);
        } catch (Exception e) {
            return new ResponseObject(false, e.getLocalizedMessage(), null);
        }

    }
}
