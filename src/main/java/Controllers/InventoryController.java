package Controllers;

import Models.Inventory;
import Services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/api/inventory")
@Transactional
public class InventoryController {
    @Autowired
    InventoryServices inventoryServices;

    @RequestMapping("/list")
    public String listInventory() {
        return inventoryServices.getAllInventory().toString();
    }

    @RequestMapping("/add")
    public void addInventory() {
        inventoryServices.save(new Inventory());
    }

    @RequestMapping(value = "/delete/{inventoryId}", method = RequestMethod.GET)
    public String deleteInventory(@PathVariable("inventoryId") Integer inventoryId) {
        inventoryServices.delete(inventoryId);
        return "delete inventory success";
    }

}
