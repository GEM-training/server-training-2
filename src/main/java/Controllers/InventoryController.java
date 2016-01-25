package Controllers;
import Dao.InventoryDao;
import Dao.InventoryDaoImpl;
import Models.Inventory;
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
@RequestMapping("/inventory")
@Transactional
public class InventoryController {
    @Autowired
    InventoryDao inventoryDao;

    @RequestMapping("/list")
    public String listInventory() {
        return inventoryDao.getAllInventory().toString();
    }

    @RequestMapping("/add")
    public void addInventory() {
        inventoryDao.save(new Inventory());
    }

    @RequestMapping(value="/delete/{inventoryId}", method = RequestMethod.GET)
    public String deleteInventory(@PathVariable("inventoryId")Integer inventoryId) {
        inventoryDao.delete(inventoryId);
        return "delete inventory success";
    }



}
