package Dao;

import Models.ProductInventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface ProductInventoryDao {
    public List<ProductInventory> getAllProductInventory();
    public void deleteProductInventory(Integer productInventoryId);
    public ProductInventory findById(Integer productInventoryId);
    public Integer save(ProductInventory product_inventory);

}
