package com.gem.server.service.impl;

import com.gem.server.dao.SaleDao;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;
import com.gem.server.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */

@Transactional
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleDao saleDao;
    public ResponseObject findAll(){
        try{
            return new ResponseObject(true, "", saleDao.findAll());
        }
        catch(Exception e){
            return new ResponseObject(false, "", null);
        }

    }

    public ResponseObject getSales(int startIndex){
        try {
            return new ResponseObject(true, "", saleDao.getSales(startIndex));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }
    public ResponseObject save(Sale sale){
        try{
            return new ResponseObject(true, "", saleDao.save(sale));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject delete(Integer saleId){
        try {
            saleDao.deleteById(saleId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e)
        {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject findById(Integer saleId){
        try{
            return new ResponseObject(true, "", saleDao.findById(saleId));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getSaleDetail(Integer saleId) {
        try{
            return new ResponseObject(true, "", saleDao.getAllSaleDetail(saleId));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

}
