package RESTControllers;

import Models.Dealer;
import Models.Inventory;
import Models.Product;
import Models.ResponseObject;
import Services.InventoryServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/api/inventory")

public class RESTInventoryController {
    @Autowired
    InventoryServices inventoryServices;

    @RequestMapping("/get")

    public
    @ResponseBody
    ResponseObject getInventories(@RequestParam(value = "start", required = false) Integer start)  {
        List<Inventory> inventories;
        try {
            if(start != null) {
                inventories = inventoryServices.getInventory(start);
            }
            else {
                inventories = inventoryServices.getAllInventory();
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
            Integer inventoryId = inventoryServices.save(inventory);
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
            inventoryServices.delete(inventoryId);
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
            Inventory inventory = inventoryServices.findById(inventodyId);
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
//            products.addAll(inventoryServices.getProducts(inentoryId));
//            return new ResponseObject(true,"",products);
//        } catch (Exception e) {
//            return new ResponseObject(false, e.getMessage(), null);
//        }
//    }

}
