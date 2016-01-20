package Dao;

import Models.Inventory;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public class InventoryDaoImpl extends AbstractDao implements InventoryDao  {

    public List<Inventory> getAllInventory() {
        Criteria criteria = getSession().createCriteria(Inventory.class);
        return (List<Inventory>) criteria.list();
    }

    public Integer save(Inventory inventory) {

        return (Integer) getSession().save(inventory);
    }

    public void deleteInventory(Integer inventoryId) {
        Inventory inventory = getSession().load(Inventory.class, inventoryId);
        if (inventory != null)
            getSession().delete(inventory);
    }

    public Inventory findById(Integer inventoryId) {
        return (Inventory) getObjectById(inventoryId);
    }

}
