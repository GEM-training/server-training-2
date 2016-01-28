package Dao;

import Models.Customer;
import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface CustomerDao {
    List<Customer> getAllCustomers();

    List<Customer> getCustomers(int startIndex);

    Integer save(Customer customer);

    void delete(Integer customerId);

    Customer findById(Integer customerId);

    List<Sale> getAllSale(Integer customerId);
}
