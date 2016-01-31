package com.gem.server.dao;

import com.gem.server.model.Customer;
import com.gem.server.model.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface CustomerDao extends GenericDao<Customer> {

    List<Customer> getCustomers(int startIndex);

    List<Sale> getAllSale(Integer customerId);
}
