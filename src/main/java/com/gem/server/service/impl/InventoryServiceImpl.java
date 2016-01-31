package com.gem.server.service.impl;

import com.gem.server.dao.InventoryDao;
import com.gem.server.model.Inventory;
import com.gem.server.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Created by nguyenkhoi on 1/25/16.
 */
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryDao inventoryDao;

    public List<Inventory> getAllInventory() {
        return inventoryDao.findAll();
    }
    public List<Inventory> getInventory(int startIndex) {

        return inventoryDao.getInventory(startIndex);
    }
    public Integer save(Inventory inventory)  {
        return inventoryDao.save(inventory);
    }

    public Inventory findById(Integer inventoryId) {
        return inventoryDao.findById(inventoryId);
    }

    public boolean delete(Integer inventoryId) {
        inventoryDao.deleteById(inventoryId);
        return true;
    }

}
