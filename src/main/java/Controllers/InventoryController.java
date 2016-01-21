package Controllers;
import Dao.InventoryDao;
import Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ""+inventoryDao.getAllInventory().size();
    }

    @RequestMapping("/add-one")
    public String addOneInventory() {
        Inventory inventory = new Inventory();
        inventory.setName("Inventory no:" +inventoryDao.getAllInventory().size() );
        return "Add inventory success";
    }

}
