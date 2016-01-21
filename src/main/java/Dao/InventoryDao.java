package Dao;

import Models.Inventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface InventoryDao {
    List<Inventory> getAllInventory();
    void delete(Integer inventoryId);
    Inventory findById(Integer inventoryId);
    Integer save(Inventory inventory);
}
