package Services.Impls;

import Dao.CustomerDao;
import Models.Customer;
import Models.Sale;
import Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public class CustomerServicesImpl implements CustomerServices{
    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Integer save(Customer customer){
        return customerDao.save(customer);
    }

    public boolean delete(Integer customerId)
    {
        try{
            customerDao.delete(customerId);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Customer findById(Integer customerId){
        return customerDao.findById(customerId);
    }

    public List<Sale> getAllSale(Integer customerId){
        return customerDao.getAllSale(customerId);
    }
}
