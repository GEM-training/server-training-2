package com.gem.server.controller;

import com.gem.server.model.ResponseObject;
import com.gem.server.model.SaleDetail;
import com.gem.server.service.SaleDetailService;
import com.gem.server.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/api/saleDetail")

public class SaleDetailController {
    @Autowired
    SaleDetailService saleDetailService;

    @RequestMapping(value = "/get-sale-details", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getSaleDetails(@RequestParam(value = "start", required = false) Integer start) {
        List<SaleDetail> saleDetais;
        try {
            if(start == null) {
                saleDetais = saleDetailService.getAllSaleDetails();
            }
            else{
                saleDetais = saleDetailService.getSaleDetails(start);
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, saleDetais);
        }
        catch (Exception e){
            e.getStackTrace();
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody SaleDetail saleDetail) {
        try{
            saleDetailService.save(saleDetail);
            return new ResponseObject(true, "", saleDetail);
        }
        catch (Exception e)
        {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("saleDetailId") Integer saleDetailId) {
        try{
            saleDetailService.delete(saleDetailId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam Integer saleDetailId) {
        try{
            SaleDetail saleDetail = saleDetailService.findById(saleDetailId);
            return new ResponseObject(true, "", saleDetail);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}
