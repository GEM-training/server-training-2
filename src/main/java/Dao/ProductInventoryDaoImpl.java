package Dao;

import Models.Product_inventory;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public class ProductInventoryDaoImpl extends AbstractDao implements ProductInventoryDao {

    public List<Product_inventory> getAllProductInventory() {
        Criteria criteria = getSession().createCriteria(Product_inventory.class);
        return (List<Product_inventory>) criteria.list();
    }

    public Integer save(Product_inventory product_inventory) {

        return (Integer) getSession().save(product_inventory);
    }

    public void deleteProductInventory(Integer productInventoryId) {
        Product_inventory product_inventory = getSession().load(Product_inventory.class, productInventoryId);
        if (product_inventory != null)
            getSession().delete(product_inventory);
    }

    public Product_inventory findById(Integer productInventoryId) {

        return (Product_inventory) getObjectById(productInventoryId);
    }

}
