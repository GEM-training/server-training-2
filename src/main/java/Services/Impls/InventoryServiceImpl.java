package Services.Impls;

import Dao.InventoryDao;
import Models.Inventory;
import Services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by nguyenkhoi on 1/25/16.
 */
public class InventoryServiceImpl implements InventoryServices{
    @Autowired
    InventoryDao inventoryDao;
    public List<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }
    public Integer save(Inventory inventory)  {
        return inventoryDao.save(inventory);
    }

    public Inventory findById(Integer inventoryId) {
        return inventoryDao.findById(inventoryId);
    }

    public boolean delete(Integer inventoryId) {
        inventoryDao.delete(inventoryId);
        return true;
    }

}
