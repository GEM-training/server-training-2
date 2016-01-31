package com.gem.server.dao;

import com.gem.server.model.Inventory;
import com.gem.server.model.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
public interface InventoryDao extends GenericDao<Inventory> {
    List<Inventory> getInventory(int startIndex);

    Set<Product> getProducts(Integer inventoryId);
}
