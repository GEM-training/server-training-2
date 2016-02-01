package com.gem.server.service.impl;

import com.gem.server.dao.SaleDetailDao;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.SaleDetail;
import com.gem.server.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */

@Transactional
public class SaleDetailServiceImpl implements SaleDetailService {
    @Autowired
    SaleDetailDao saleDetailDao;

    public ResponseObject findAll() {
        try{
            return new ResponseObject(true, "", saleDetailDao.findAll());
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getSaleDetails(int startIndex) {
        try{
            return new ResponseObject(true, "", saleDetailDao.getSaleDetails(startIndex));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject save(SaleDetail saleDetail) {
        try{
            return new ResponseObject(true, "", saleDetailDao.save(saleDetail));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject delete(Integer saleDetailId) {
        try{
            saleDetailDao.deleteById(saleDetailId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject findById(Integer saleDetailId) {
        try{
            return new ResponseObject(true, "", saleDetailDao.findById(saleDetailId));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }
}

