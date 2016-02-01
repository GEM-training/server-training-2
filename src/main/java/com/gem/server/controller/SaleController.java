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
@RequestMapping("/sale")

public class SaleController {
    @Autowired
    SaleService saleService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) {
            if(start == null) {
                return saleService.findAll();
            }
            else{
                return saleService.getSales(start);
            }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody Sale sale) throws Exception{
        return saleService.save(sale);
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("saleId") Integer saleId) throws Exception{
        return saleService.delete(saleId);
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam("saleId") Integer saleId) throws Exception{
            return saleService.findById(saleId);
    }
}


