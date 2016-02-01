package com.gem.server.service;

import com.gem.server.model.Customer;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface CustomerService {
    ResponseObject findAll();

    ResponseObject getCustomers(int startIndex);

    ResponseObject save(Customer customer);

    ResponseObject delete(Integer customerId);

    ResponseObject findById(Integer customerId);

    ResponseObject getAllSale(Integer customerId);
}
