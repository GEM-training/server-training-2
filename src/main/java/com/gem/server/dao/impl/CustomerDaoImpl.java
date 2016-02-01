package com.gem.server.dao.impl;

import com.gem.server.utils.Constants;
import com.gem.server.dao.CustomerDao;
import com.gem.server.model.Customer;
import com.gem.server.model.Sale;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */

@Configuration
@PropertySource("classpath:config.properties")
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {
    @Autowired
    Environment env;
    private String propertyOrder;
    private int pageSize;

    public CustomerDaoImpl() {
        super(Customer.class);
    }

    public List<Customer> getCustomers(int startIndex) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        propertyOrder = env.getProperty(Constants.CUSTOMER.order);
        pageSize = Integer.parseInt(Constants.CUSTOMER.page_size);
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        return (List<Customer>) criteria.list();
    }

    public List<Sale> getAllSale(Integer customerId) {
        Customer c = findById(customerId);
        return (List<Sale>) c.getSetSales();
    }

}
