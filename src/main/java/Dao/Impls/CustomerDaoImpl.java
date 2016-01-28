package Dao.Impls;

import Dao.AbstractDao;
import Dao.CustomerDao;
import Models.Customer;
import Models.Sale;
import Utils.Constants;
import com.sun.xml.internal.ws.api.PropertySet;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.core.env.Environment;

/**
 * Created by jojo on 20/01/2016.
 */
@Transactional
@Configuration
@PropertySource("classpath:Config.properties")
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    @Autowired
    Environment env;

    public List<Customer> getAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return (List<Customer>) criteria.list();
    }

    public List<Customer> getCustomers(int startIndex) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        String propertyOrder = env.getProperty(Constants.CUSTOMER.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(Constants.CUSTOMER.PAGE_SIZE);
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
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
