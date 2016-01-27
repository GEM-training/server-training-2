package Controllers.RESTControllers;

import Models.Inventory;
import Models.ResponseObject;
import Services.InventoryServices;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Constants;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/api/inventory")

public class RESTInventoryController {
    @Autowired
    InventoryServices inventoryServices;

    @RequestMapping("/list")

    public
    @ResponseBody
    ResponseObject getInventories() {
        try {
            List<Inventory> inventories = inventoryServices.getAllInventory();
            return new ResponseObject(true, Utils.Constants.HTTP.SUCCESS, inventories);
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
        }catch (Exception e) {
            return new ResponseObject(false,e.getMessage(), null);
        }
    }
    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject findInventory(@RequestParam("inventoryId") Integer inventodyId) {
        try {
            Inventory inventory = inventoryServices.findById(inventodyId);
            return new ResponseObject(true,"", inventory);
        }catch (Exception e) {
            return new ResponseObject(false,e.getMessage(), null);
        }
    }

}
