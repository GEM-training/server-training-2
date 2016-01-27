package Dao.Impls;

import Dao.AbstractDao;
import Dao.CustomerDao;
import Models.Customer;
import Models.Sale;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
@Transactional
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    public List<Customer> getAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return (List<Customer>) criteria.list();
    }

    public Integer save(Customer customer) {
        return (Integer) getSession().save(customer);
    }

    public void delete(Integer customerId) {
        Customer customer = getSession().load(Customer.class, customerId);
        if (customer != null) {
            getSession().delete(customer);
        }
    }

    public Customer findById(Integer customerId) {
        Customer customer = getSession().get(Customer.class, customerId);
        return customer;
    }

    public List<Sale> getAllSale(Integer customerId) {
        Customer c = findById(customerId);
        return (List<Sale>) c.getSetSales();
    }

}
