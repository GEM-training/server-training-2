package com.gem.server.service.impl;

import com.gem.server.dao.SaleDao;
import com.gem.server.model.Sale;
import com.gem.server.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleDao saleDao;
    public List<Sale> getAllSales(){
        return saleDao.findAll();
    }

    public List<Sale> getSales(int startIndex){
        return saleDao.getSales(startIndex);
    }

    public Integer save(Sale sale){
        return saleDao.save(sale);
    }

    public boolean delete(Integer saleId){
        try {
            saleDao.deleteById(saleId);
            return true;
        }
        catch (Exception e)
        {
            e.getStackTrace();
            return false;
        }
    }

    public Sale findById(Integer saleId){
        return saleDao.findById(saleId);
    }
}
