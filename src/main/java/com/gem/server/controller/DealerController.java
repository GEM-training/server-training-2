package com.gem.server.controller;

import com.gem.server.model.Dealer;
import com.gem.server.model.Make;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/api/dealer")

public class DealerController {
    @Autowired
    DealerService dealerService;


    //@Qualifier(value = "dealerServices")
    @RequestMapping(value = "/get")
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) throws Exception {
        if (start != null) {
            //return  dealerService.findAll();
            return dealerService.getDealers(start);
        } else {
            return dealerService.findAll();
        }
    }

    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject save(@RequestBody Dealer dealer) throws Exception {
        return dealerService.save(dealer);
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("dealerId") int dealerId) throws Exception {
        return dealerService.deleteById(dealerId);

    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody @Valid Dealer dealer, BindingResult error) throws Exception {

        if (error.hasErrors())
            return new ResponseObject(false, error.getAllErrors().get(0).getDefaultMessage(), null);
        return dealerService.update(dealer);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject find(@RequestParam("dealerId") int dealerId) throws Exception {
        return dealerService.findById(dealerId);
    }


    @RequestMapping(value = "/get-staff", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getStaff(@RequestParam("dealerId") int dealerId) throws Exception {
        return dealerService.getStaffs(dealerId);
    }

    @RequestMapping(value = "/get-inventory", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getInventory(@RequestParam("dealerId") int dealerId) throws Exception {
        return dealerService.getInventories(dealerId);

    }

    @RequestMapping(value = "/get-product", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getProduct(@RequestParam("dealerId") int dealerId) throws Exception {
        return dealerService.getProducts(dealerId);
    }


}
