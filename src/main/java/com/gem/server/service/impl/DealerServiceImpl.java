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




    public ResponseObject findById(Integer id) {
        return new ResponseObject(true,"",dealerDao.findById(id));
    }

    public ResponseObject findAll() {
        return new ResponseObject(true,"",dealerDao.findAll());
    }

    public ResponseObject save(Dealer dealer) {
        try {
            Integer dealerId = dealerDao.save(dealer);
            return new ResponseObject(true, "", dealerId);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject update(Dealer dealer) {
        Dealer oldDealer = dealerDao.findById(dealer.getDealerId());
        try {
            dealerDao.update(dealer);
            return new ResponseObject(true, "", dealer);
        } catch (Exception e) {
            return new ResponseObject(false, "", oldDealer);
        }
    }

    public ResponseObject delete(Dealer dealer) {
        return null;
    }


    public ResponseObject deleteById(Integer dealerId) {
        try {
            dealerDao.deleteById(dealerId);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getDealers(int startIndex) {
        try {
            return new ResponseObject(true, "", dealerDao.getDealers(startIndex));
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

    public ResponseObject getStaffs(Integer dealerId) {
        try {
            return new ResponseObject(true, "", dealerDao.getStaffs(dealerId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }
}
