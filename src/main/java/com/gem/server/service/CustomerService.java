package com.gem.server.service;

import com.gem.server.model.Customer;
import com.gem.server.model.Sale;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();

    List<Customer> getCustomers(int startIndex);

    Integer save(Customer customer);

    boolean delete(Integer customerId);

    Customer findById(Integer customerId);

    List<Sale> getAllSale(Integer customerId);
}
