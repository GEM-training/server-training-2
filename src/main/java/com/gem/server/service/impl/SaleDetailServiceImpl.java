package com.gem.server.service.impl;

import com.gem.server.dao.SaleDetailDao;
import com.gem.server.model.SaleDetail;
import com.gem.server.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public class SaleDetailServiceImpl implements SaleDetailService {
    @Autowired
    SaleDetailDao saleDetailDao;

    public List<SaleDetail> getAllSaleDetails(){
        return saleDetailDao.findAll();
    }

    public List<SaleDetail> getSaleDetails(int startIndex){
        return saleDetailDao.getSaleDetails(startIndex);
    }

    public Integer save(SaleDetail saleDetail){
        return saleDetailDao.save(saleDetail);
    }

    public boolean delete(Integer saleDetailId){
        try{
            saleDetailDao.deleteById(saleDetailId);
            return true;}
        catch(Exception e)
        {
            return false;
        }
    }

    public SaleDetail findById(Integer saleDetailId){
        return saleDetailDao.findById(saleDetailId);
    }
}
