package com.gem.server.controller;

import com.gem.server.model.ResponseObject;
import com.gem.server.model.SaleDetail;
import com.gem.server.service.SaleDetailService;
import com.gem.server.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/saleDetail")

public class SaleDetailController {
    @Autowired
    SaleDetailService saleDetailService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) {
        if(start == null) {
            return saleDetailService.findAll();
        }
        else{
            return saleDetailService.getSaleDetails(start);
        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody SaleDetail saleDetail) {
        return saleDetailService.save(saleDetail);
    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody SaleDetail saleDetail) {
        return saleDetailService.update(saleDetail);
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("saleDetailId") Integer saleDetailId) {
        return saleDetailService.delete(saleDetailId);
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam Integer saleDetailId) {
        return saleDetailService.findById(saleDetailId);
    }
}
