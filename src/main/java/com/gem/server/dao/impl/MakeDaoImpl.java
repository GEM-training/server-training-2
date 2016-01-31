package com.gem.server.dao.impl;

import com.gem.server.Utils.Constants;
import com.gem.server.dao.MakeDao;
import com.gem.server.model.Make;
import com.gem.server.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
@Configuration
@PropertySource("classpath:Config.properties")
public class MakeDaoImpl extends GenericDaoImpl<Make> implements MakeDao {
    @Autowired
    Environment env;
    @Autowired
    SessionFactory sessionFactory;

    public MakeDaoImpl() {
        super(Make.class);
    }

    public List<Make> getMakes(int startIndex) {
        Criteria criteria = getSession().createCriteria(Make.class);
        String propertyOrder = env.getProperty(Constants.MAKE.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(env.getProperty(Constants.MAKE.PAGE_SIZE));
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        return (List<Make>) criteria.list();
    }

    public Set<Product> getProducts(Integer makeId) {
        Make make = findById(makeId);
        Hibernate.initialize(make.getSetProducts());
        return make.getSetProducts();
    }

}
