package Dao;

import Models.Customer;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface CustomerDao {
    public List<Customer> getAllMakes();
    public Integer save(Customer customer);
    public void deleteCustomer(Integer customerId);
    public Customer findById(Integer customerId);
}
