package Services;

import Models.Inventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public interface InventoryServices {
    List<Inventory> getAllInventory();

    boolean delete(Integer inventoryId);

    Inventory findById(Integer inventoryId);

    Integer save(Inventory inventory);
}
