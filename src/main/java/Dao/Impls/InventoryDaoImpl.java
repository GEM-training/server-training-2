package Dao.Impls;

import Dao.AbstractDao;
import Dao.InventoryDao;
import Models.Inventory;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
@Transactional
public class InventoryDaoImpl extends AbstractDao implements InventoryDao {

    public List<Inventory> getAllInventory() {
        Criteria criteria = getSession().createCriteria(Inventory.class);
        return (List<Inventory>) criteria.list();
    }

    public void delete(Integer inventoryId) {
        Inventory inventory = getSession().load(Inventory.class, inventoryId);
        if (inventory != null)
            getSession().delete(inventory);
    }

    public Integer save(Inventory inventory) {

        return (Integer) getSession().save(inventory);
    }


    public Inventory findById(Integer inventoryId) {
        return getSession().get(Inventory.class, inventoryId);
    }

}
