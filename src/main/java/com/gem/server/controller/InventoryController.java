package com.gem.server.controller;

import com.gem.server.dao.InventoryDao;

import com.gem.server.model.Inventory;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/inventory")

public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @RequestMapping("/get")
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) {
        if (start != null) {
            return inventoryService.getInventory(start);
        } else {
            return inventoryService.findAll();
        }
    }

    @RequestMapping("/delete")
    public
    @ResponseBody
    ResponseObject deleteInventory(@RequestParam("inventoryId") Integer inventoryId) {
        return inventoryService.deleteById(inventoryId);
    }

    @RequestMapping("/save")
    public
    @ResponseBody
    ResponseObject save(@RequestBody @Valid  Inventory inventory , BindingResult errors) throws Exception {
        if (errors.hasErrors())
            return new ResponseObject(false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        return inventoryService.save(inventory);
    }

    @RequestMapping("/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody @Valid Inventory inventory, BindingResult errors) throws Exception {
        if (errors.hasErrors())
            return new ResponseObject(false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        return inventoryService.update(inventory);
    }



//
//        List<Inventory> i
//        try {
//            if(start != null) {
//                inventories = inventoryService.getInventory(start);
//            }
//            else {
//                inventories = inventoryService.getAllInventory();
//            }
//            return new ResponseObject(true, Constants.HTTP.SUCCESS, inventories);
//
//        } catch (Exception e) {
//            return new ResponseObject(false, e.getMessage(), null);
//        }
//    }

//    @RequestMapping("/save")
//    public
//    @ResponseBody
//    ResponseObject addInventoris(@RequestBody Inventory inventory) {
//        try {
//            Integer inventoryId = inventoryService.save(inventory);
//            return new ResponseObject(true, "", inventoryId);
//        } catch (Exception e) {
//            return new ResponseObject(false, e.getMessage(), null);
//        }
//    }

//    @RequestMapping(value = "/delete")
//    public
//    @ResponseBody
//    ResponseObject deleteInventory(@RequestParam("inventoryId") Integer inventoryId) {
//        try {
//            inventoryService.delete(inventoryId);
//            return new ResponseObject(true, "", null);
//        } catch (Exception e) {
//            return new ResponseObject(false, e.getMessage(), null);
//        }
//    }

//    @RequestMapping(value = "/find")
//    public
//    @ResponseBody
//    ResponseObject findInventory(@RequestParam("inventoryId") Integer inventodyId) {
//        try {
//            Inventory inventory = inventoryService.findById(inventodyId);
//            return new ResponseObject(true, "", inventory);
//        } catch (Exception e) {
//            return new ResponseObject(false, e.getMessage(), null);
//        }
//    }

//    @RequestMapping(value = "/get-product")
//    public
//    @ResponseBody
//    ResponseObject getDealer(@RequestParam("inventoryId") Integer inentoryId) {
//        try {
//            List<Product> products = new ArrayList<Product>();
//
//            products.addAll(inventoryService.getProducts(inentoryId));
//            return new ResponseObject(true,"",products);
//        } catch (Exception e) {
//            return new ResponseObject(false, e.getMessage(), null);
//        }
//    }

}
