package com.gem.server.service.impl;

import com.gem.server.dao.DealerDao;
import com.gem.server.model.Dealer;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by phong on 1/22/2016.
 */
@Transactional
public class DealerServiceImpl implements DealerService {
    @Autowired
    DealerDao dealerDao;

    //TODO catch business exceptions


    public ResponseObject findById(long id) {
        return null;
    }

    public ResponseObject findAll() {
        return null;
    }

    public ResponseObject save(Dealer dealer) {
        return null;
    }

    public ResponseObject update(Dealer dealer) {
        return null;
    }

    public ResponseObject delete(Dealer dealer) {
        return null;
    }

    public ResponseObject deleteById(long dealerId) {
        return null;
    }

    public ResponseObject getDealers(int startIndex) {
        try {
            return new ResponseObject(true, "", dealerDao.getDealer(startIndex));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getProducts(Integer dealerId) {
        try {
            return new ResponseObject(true, "", dealerDao.getProducts(dealerId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getInventories(Integer dealerId) {
        try {
            return new ResponseObject(true, "", dealerDao.getInventories(dealerId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getSales(Integer dealerId) {
        try {
            return new ResponseObject(true, "", dealerDao.getSales(dealerId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }
}
