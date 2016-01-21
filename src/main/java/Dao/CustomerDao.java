package Dao;

import Models.Customer;
import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface CustomerDao {
    public List<Customer> getAllCustomers();

    public Integer save(Customer customer);

    public void delete(Integer customerId);

    public Customer findById(Integer customerId);

    public List<Sale> getAllSale(Integer customerId);
}
