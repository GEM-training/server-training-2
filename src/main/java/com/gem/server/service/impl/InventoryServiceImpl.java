package com.gem.server.service.impl;

import com.gem.server.dao.InventoryDao;
import com.gem.server.model.Inventory;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nguyenkhoi on 1/25/16.
 */


@Transactional
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryDao inventoryDao;

    public ResponseObject findById(Integer id) {
        return new ResponseObject(true, "", inventoryDao.findById(id));
    }

    public ResponseObject findAll() {
        try {
            return new ResponseObject(true, "", inventoryDao.findAll());
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject save(Inventory inventory) {
        try {
            Integer inventoryId = inventoryDao.save(inventory);
            return new ResponseObject(true, "", inventoryId);
        } catch (Exception e) {
            return  new ResponseObject(false, "", null);
        }
    }

    public ResponseObject update(Inventory inventory) {

        try {
            inventoryDao.update(inventory);
            return new ResponseObject(true, "", inventory);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject delete(Inventory inventory) {
        try {
            inventoryDao.delete(inventory);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject deleteById(Integer inventoryId) {
        try {
            inventoryDao.deleteById(inventoryId);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getInventory(Integer startIndex) {
        try {
            return new ResponseObject(true, "", inventoryDao.getInventory(startIndex));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getProducts(Integer productId) {
        try {
            return new ResponseObject(true,"", inventoryDao.getProducts(productId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

}
