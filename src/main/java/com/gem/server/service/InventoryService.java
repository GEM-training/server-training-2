package com.gem.server.service;

import com.gem.server.model.Inventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public interface InventoryService {
    List<Inventory> getAllInventory();
    List<Inventory> getInventory(int startIndex);

    boolean delete(Integer inventoryId);

    Inventory findById(Integer inventoryId);

    Integer save(Inventory inventory);
}
