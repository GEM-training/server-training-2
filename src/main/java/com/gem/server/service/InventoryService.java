package com.gem.server.service;

import com.gem.server.model.Inventory;
import com.gem.server.model.ResponseObject;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public interface InventoryService {
    ResponseObject findById(Integer id);

    ResponseObject findAll();

    ResponseObject save(Inventory inventory);

    ResponseObject update(Inventory inventory);

    ResponseObject delete(Inventory inventory);

    ResponseObject deleteById(long dealerId);

    ResponseObject getInventory(int startIndex);

    ResponseObject getProducts(Integer productId);
}
