package com.gem.server.service.impl;

import com.gem.server.dao.ProductDao;
import com.gem.server.model.*;
import com.gem.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hoak57uet on 1/21/16.
 */
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    public ResponseObject findById(Integer id) {
        return new ResponseObject(true, "", productDao.findById(id));
    }

    public ResponseObject findAll() {
        try {
            return new ResponseObject(true, "", productDao.findAll());
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject save(Product product) {
        try {
            Integer productId = productDao.save(product);
            return new ResponseObject(true, "", productId);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject update(Product product) {
        Product oldProduct = productDao.findById(product.getProductId());
        try {
            productDao.update(product);
            return new ResponseObject(true, "", product);
        } catch (Exception e) {
            return new ResponseObject(false, "", oldProduct);
        }
    }

    public ResponseObject delete(Product product) {
        try {
            productDao.delete(product);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject deleteById(Integer productId) {
        try {
            productDao.deleteById(productId);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getProducts(int startIndex) {
        try {
            return new ResponseObject(true, "", productDao.getProduct(startIndex));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getDealers(Integer productId) {
        try {
            return new ResponseObject(true, "", productDao.getDealers(productId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getMake(Integer productId) {
        try {
            return new ResponseObject(true, "", productDao.getMake(productId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getSales(Integer productId) {
        try {
            return new ResponseObject(true, "", productDao.getSales(productId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getParts(Integer productId) {
        try {
            return new ResponseObject(true, "", productDao.getParts(productId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }
}
