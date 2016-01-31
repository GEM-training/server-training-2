package com.gem.server.service;

import com.gem.server.model.ProductInventory;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public interface ProductInventoryService {
    List<ProductInventory> getAllProductInventory();

    void delete(Integer productInventoryId);

    ProductInventory findById(Integer productInventoryId);

    Integer save(ProductInventory product_inventory);


}
