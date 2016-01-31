package com.gem.server.controller;

import com.gem.server.model.Customer;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.CustomerService;
import com.gem.server.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/api/customer")

public class CustomerController {
    @Autowired
    CustomerService customerServices;

    @RequestMapping(value = "/get-customers", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getCustomers(@RequestParam(value = "start", required = false) Integer start) {
        List<Customer> customers;
        try {
            if(start == null) {
                customers = customerServices.getAllCustomers();
            }
            else{
                customers = customerServices.getCustomers(start);
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, customers);
        }
        catch (Exception e){
            e.getStackTrace();
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


