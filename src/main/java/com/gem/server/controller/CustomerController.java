package com.gem.server.controller;

import com.gem.server.model.Customer;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;
import com.gem.server.service.CustomerService;
import com.gem.server.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    CustomerService customerServices;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) {
            if(start == null) {
                return customerServices.findAll();
            }
            else{
                return customerServices.getCustomers(start);
            }

    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody @Valid Customer customer, BindingResult error) throws Exception{
        if(error.hasErrors()){
            return new ResponseObject(false, error.getAllErrors().get(0).getDefaultMessage(), null);
        }
            return customerServices.save(customer);
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("customerId") Integer customerId) throws Exception {
        return customerServices.delete(customerId);
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam("customerId") Integer customerId) {
            return customerServices.findById(customerId);

    }

    @RequestMapping(value = "/get-all-sale")
    public
    @ResponseBody
    ResponseObject getAllSale(@RequestParam("customerId")  Integer customerId) {
            return customerServices.getAllSale(customerId);
    }
}


