package com.gem.server.service.impl;

import com.gem.server.dao.ProductInventoryDao;
import com.gem.server.model.ProductInventory;
import com.gem.server.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/25/16.
 */
public class ProductInventoryServiceImpl implements ProductInventoryService {
    @Autowired
    ProductInventoryDao productInventoryDao;
    public List<ProductInventory> getAllProductInventory() {
        return productInventoryDao.findAll();
    }
    public Integer save(ProductInventory productInventory) {
        return productInventoryDao.save(productInventory);
    }
    public ProductInventory findById(Integer productInventoryId) {
        return productInventoryDao.findById(productInventoryId);
    }
    public void delete(Integer productInventoryId) {
        productInventoryDao.deleteById((productInventoryId));
    }
}
