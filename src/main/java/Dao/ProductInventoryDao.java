package Dao;

import Models.Product_inventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface ProductInventoryDao {
    public List<Product_inventory> getAllProductInventory();
    public void deleteProductInventory(Integer productInventoryId);
    public Product_inventory findById(Integer productInventoryId);
    public Integer save(Product_inventory product_inventory);

}
