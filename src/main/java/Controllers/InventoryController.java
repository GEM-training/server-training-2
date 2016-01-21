package Controllers;
import Dao.InventoryDao;
import Dao.InventoryDaoImpl;
import Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/21/16.
 */

@RestController
@RequestMapping("/inventory")
@Transactional
public class InventoryController {
    @Autowired
    InventoryDao inventoryDao;

    @RequestMapping("/list")
    public String listInventory() {
        return " "+inventoryDao.getAllInventory().size();
    }

    @RequestMapping("/add-one")
    public String addOneInventory() {
        Inventory inventory = new Inventory();
        inventory.setName("Inventory no:" +inventoryDao.getAllInventory().size() );
        return "Add inventory success";
    }

    @RequestMapping(value="/delete{id}")
    public String deleteInventory(@PathVariable("id") int inventoryId) {
        inventoryDao.deleteInventory(inventoryId);
        return "delete inventory sucess";
    }



}
