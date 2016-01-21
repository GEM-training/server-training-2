package Dao;

import Models.Inventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface InventoryDao {
    public List<Inventory> getAllInventory();
    public void delete(Integer inventoryId);
    public Inventory findById(Integer inventoryId);
    public Integer save(Inventory inventory);
}
