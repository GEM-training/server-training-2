package Dao;

import Models.ProductInventory;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public class ProductInventoryDaoImpl extends AbstractDao implements ProductInventoryDao {

    public List<ProductInventory> getAllProductInventory() {
        Criteria criteria = getSession().createCriteria(ProductInventory.class);
        return (List<ProductInventory>) criteria.list();
    }

    public void delete(Integer productInventoryId) {
        ProductInventory product_inventory = getSession().load(ProductInventory.class, productInventoryId);
        if (product_inventory != null)
            getSession().delete(product_inventory);
    }

    public Integer save(ProductInventory product_inventory) {

        return (Integer) getSession().save(product_inventory);
    }

    public ProductInventory findById(Integer productInventoryId) {

        return (ProductInventory) getObjectById(productInventoryId);
    }

}
