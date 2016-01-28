package Dao;

import Models.Inventory;
import Models.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface InventoryDao {
    List<Inventory> getAllInventory();


    void delete(Integer inventoryId);

    Inventory findById(Integer inventoryId);

    Integer save(Inventory inventory);

    List<Inventory> getInventory(int startIndex);

    //Set<Product> getProducts(Integer inventoryId);
}
