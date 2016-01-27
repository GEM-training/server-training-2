package Services;

import Models.Customer;
import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface CustomerServices {
    List<Customer> getAllCustomers();

    Integer save(Customer customer);

    boolean delete(Integer customerId);

    Customer findById(Integer customerId);

    List<Sale> getAllSale(Integer customerId);
}
