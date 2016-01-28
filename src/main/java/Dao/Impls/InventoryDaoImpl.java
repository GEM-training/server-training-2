package Dao.Impls;

import Dao.AbstractDao;
import Dao.InventoryDao;
import Models.Inventory;
import Models.Product;
import org.hibernate.Criteria;
import Utils.Constants;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
@Transactional
@Configuration
@PropertySource("classpath:Config.properties")
public class InventoryDaoImpl extends AbstractDao implements InventoryDao {
    @Autowired
    Environment env;

    public List<Inventory> getAllInventory() {
        Criteria criteria = getSession().createCriteria(Inventory.class);
        return (List<Inventory>) criteria.list();
    }

    public List<Inventory> getInventory(int startIndex) {
        Criteria criteria = getSession().createCriteria(Inventory.class);
        String propertyOrder = env.getProperty(Constants.INVENTORY.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(env.getProperty(Constants.INVENTORY.PAGE_SIZE));

        criteria.addOrder(Order.asc(propertyOrder));
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        criteria.setMaxResults(pageSize);
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
