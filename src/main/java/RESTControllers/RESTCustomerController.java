package RESTControllers;

import Models.Customer;
import Models.ResponseObject;
import Services.CustomerServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/api/customer")

public class RESTCustomerController {
    @Autowired
    CustomerServices customerServices;

    @RequestMapping(value = "/view-all", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject viewAll() {
        try {
            List<Customer> customerList = customerServices.getAllCustomers();
            return new ResponseObject(true, Constants.HTTP.SUCCESS, customerList);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody Customer customer) {
        try {
            Integer customerId = customerServices.save(customer);
            return new ResponseObject(true,"", customerId);
        }
        catch(Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("customerId") Integer customerId) {
        try {
            customerServices.delete(customerId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e){
            return new ResponseObject(false,e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam("customerId") Integer customerId) {
        try {
            Customer customer = customerServices.findById(customerId);
            return new ResponseObject(true, "", customer);
        }
        catch(Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

}


