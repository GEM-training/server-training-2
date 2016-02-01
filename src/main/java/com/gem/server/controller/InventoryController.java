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

    @RequestMapping("/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam("inventoryId") Integer inventoryId) {
        return inventoryService.findById(inventoryId);
    }

}
