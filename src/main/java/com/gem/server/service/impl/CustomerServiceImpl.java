package com.gem.server.service.impl;

import com.gem.server.dao.CustomerDao;
import com.gem.server.model.Customer;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;
import com.gem.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    public ResponseObject findAll() {
        try{
            return new ResponseObject(true, "", customerDao.findAll());
        }
        catch (Exception e)
        {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getCustomers(int startIndex){
        try{
           return new ResponseObject(true, "", customerDao.getCustomers(startIndex));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }

    }

    public ResponseObject save(Customer customer) {
        try{
            Integer customerId = customerDao.save(customer);
            return new ResponseObject(true, "", customerId);
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject update(Customer customer) {
        try{
            customerDao.update(customer);
            return new ResponseObject(true, "", null);
        }
        catch(Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject delete(Integer customerId) {
        try {
            customerDao.deleteById(customerId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject findById(Integer customerId) {
        return new ResponseObject(true, "", customerDao.findById(customerId));
    }

    public ResponseObject getAllSale(Integer customerId) {
        try {
            return new ResponseObject(true, "",customerDao.getAllSale(customerId));
        }
        catch (Exception e){
            return new ResponseObject(false, "", null);
        }
    }
}
