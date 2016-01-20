package Dao;

import Models.Customer;
import Models.Make;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public class CustomerDaoImpl extends AbstractDao implements CustomerDao{
    public List<Customer> getAllMakes(){
        Criteria criteria = getSession().createCriteria(Customer.class);
        return (List<Customer>)criteria.list();
    }

    public Integer save(Customer customer){
        return (Integer)getSession().save(customer);
    }

    public void deleteCustomer(Integer customerId){
        Customer customer = getSession().load(Customer.class, customerId);
        if(customer != null)
        {
            getSession().delete(customer);
        }
    }

    public Customer findById(Integer customerId){
        return (Customer)getObjectById(customerId);
    }
}
