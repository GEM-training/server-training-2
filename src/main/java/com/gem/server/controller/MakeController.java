package com.gem.server.controller;

import com.gem.server.model.Make;
import com.gem.server.model.Product;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.MakeService;
import com.gem.server.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
@RestController
@RequestMapping("/make")

public class MakeController {
    @Autowired
    MakeService makeService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getMakes(@RequestParam(value = "start", required = false) Integer start) throws Exception {
        if (start == null) {
            return makeService.findAll();
        } else {
            return makeService.getMakes(start);
        }

    }

    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject save(@RequestBody @Valid Make make, BindingResult error) throws Exception {
        if (error.hasErrors())
            return new ResponseObject(false, error.getAllErrors().get(0).getDefaultMessage(), null);
        return makeService.save(make);
    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody @Valid Make make, BindingResult error) throws Exception {

        if (error.hasErrors())
            return new ResponseObject(false, error.getAllErrors().get(0).getDefaultMessage(), null);
        return makeService.update(make);
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("makeId") Integer makeId) throws Exception {
        return makeService.deleteById(makeId);

    }

    @RequestMapping(value = "/get-products")
    public
    @ResponseBody
    ResponseObject getProducts(@RequestParam("makeId") Integer makeId) throws Exception {
        return makeService.getProducts(makeId);
    }
}
