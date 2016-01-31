package com.gem.server.controller;

import com.gem.server.dao.ProductDao;
import com.gem.server.model.Product;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by hoapham on 20/01/2016.
 */
@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteProduct(@RequestParam("productId") Integer productId) throws Exception {
        return productService.deleteById(productId);

    }

    @RequestMapping(value = "/get")
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) {
        if (start != null) {
            return productService.getProducts(start);
        } else {
            return productService.findAll();
        }
    }

    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject save(@RequestBody @Valid Product product, BindingResult errors) throws Exception {
        if (errors.hasErrors())
            return new ResponseObject(false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        return productService.save(product);
    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody @Valid Product product, BindingResult errors) throws Exception {
        if (errors.hasErrors())
            return new ResponseObject(false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        return productService.update(product);
    }

    @RequestMapping(value = "/get-parts")
    public
    @ResponseBody
    ResponseObject getParts(@RequestParam("productId") Integer productId) throws Exception {
        return productService.getParts(productId);

    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject getProduct(@RequestParam("productId") Integer productId) throws Exception {
        return productService.findById(productId);

    }

    @RequestMapping(value = "/get-dealers")
    public
    @ResponseBody
    ResponseObject getDealers(@RequestParam("productId") Integer productId) throws Exception {
        return productService.getDealers(productId);

    }

}
