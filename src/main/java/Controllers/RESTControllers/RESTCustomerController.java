package Controllers.RESTControllers;

import Models.Customer;
import Models.ResponseObject;
import Services.CustomerServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/api/customer")
@Transactional
public class RESTCustomerController {
    @Autowired
    CustomerServices customerServices;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getListCustomer() {
        try {
            List<Customer> customerList = customerServices.getAllCustomers();
            return new ResponseObject(true, Constants.HTTP.SUCCESS, customerList);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add-one")
    public
    @ResponseBody
    ResponseObject addOneCustomer(@RequestBody Customer customer) {
        try {
            Integer customerId = customerServices.save(customer);
            return new ResponseObject(true,"", customerId);
        }
        catch(Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete-one")
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

    @RequestMapping(value = "/find-one")
    public
    @ResponseBody
    ResponseObject findCustomer(@RequestParam("customerId") Integer customerId) {
        try {
            Customer customer = customerServices.findById(customerId);
            return new ResponseObject(true, "", customer);
        }
        catch(Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

//    @RequestMapping(value = "/greeting")
//    public ResponseEntity<Customer> greeting(@RequestParam(value="name", defaultValue="World") String name,
//                                             @RequestParam(value="id", defaultValue="100") int id) {
//        Customer customer = new Customer();
//        customer.setCustomerId(id);
//        customer.setName(name);
//        return new ResponseEntity<Customer> (customer, HttpStatus.BAD_REQUEST);
//    }
}


