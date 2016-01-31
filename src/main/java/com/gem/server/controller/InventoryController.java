package com.gem.server.controller;

import com.gem.server.model.Inventory;
import com.gem.server.model.ResponseObject;
import com.gem.server.Utils.Constants;
import com.gem.server.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/api/inventory")

public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @RequestMapping("/get")

    public
    @ResponseBody
    ResponseObject getInventories(@RequestParam(value = "start", required = false) Integer start)  {
        List<Inventory> inventories;
        try {
            if(start != null) {
                inventories = inventoryService.getInventory(start);
            }
            else {
                inventories = inventoryService.getAllInventory();
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, inventories);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping("/save")
    public
    @ResponseBody
    ResponseObject addInventoris(@RequestBody Inventory inventory) {
        try {
            Integer inventoryId = inventoryService.save(inventory);
            return new ResponseObject(true, "", inventoryId);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteInventory(@RequestParam("inventoryId") Integer inventoryId) {
        try {
            inventoryService.delete(inventoryId);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject findInventory(@RequestParam("inventoryId") Integer inventodyId) {
        try {
            Inventory inventory = inventoryService.findById(inventodyId);
            return new ResponseObject(true, "", inventory);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

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
