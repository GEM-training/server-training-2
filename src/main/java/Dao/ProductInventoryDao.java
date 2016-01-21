package Dao;

import Models.ProductInventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface ProductInventoryDao {
    List<ProductInventory> getAllProductInventory();

    void delete(Integer productInventoryId);

    ProductInventory findById(Integer productInventoryId);

    Integer save(ProductInventory product_inventory);

}
