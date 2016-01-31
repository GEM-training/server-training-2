package com.gem.server.service.impl;

import com.gem.server.dao.CustomerDao;
import com.gem.server.model.Customer;
import com.gem.server.model.Sale;
import com.gem.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public List<Customer> getCustomers(int startIndex){
        return customerDao.getCustomers(startIndex);
    }

    public Integer save(Customer customer) {
        return customerDao.save(customer);
    }

    public boolean delete(Integer customerId) {
        try {
            customerDao.deleteById(customerId);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Customer findById(Integer customerId) {
        return customerDao.findById(customerId);
    }

    public List<Sale> getAllSale(Integer customerId) {
        return customerDao.getAllSale(customerId);
    }
}
