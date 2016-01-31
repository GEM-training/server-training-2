package com.gem.server.controller;

import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;
import com.gem.server.service.SaleService;
import com.gem.server.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/api/sale")

public class SaleController {
    @Autowired
    SaleService saleService;

    @RequestMapping(value = "/get-sales", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getSales(@RequestParam(value = "start", required = false) Integer start) {
        List<Sale> sales;
        try {
            if(start == null) {
                sales = saleService.getAllSales();
            }
            else{
                sales = saleService.getSales(start);
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, sales);
        }
        catch (Exception e){
            e.getStackTrace();
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody Sale sale) {
        try {
            Integer saleId = saleService.save(sale);
            return new ResponseObject(true, "", saleId);
        }
        catch(Exception e)
        {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("saleId") Integer saleId) {
        try{
            saleService.delete(saleId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam("saleId") Integer saleId) {
        try{
            Sale sale = saleService.findById(saleId);
            return new ResponseObject(true, "", sale);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}


