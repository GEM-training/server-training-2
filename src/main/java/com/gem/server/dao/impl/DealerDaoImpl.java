package com.gem.server.dao.impl;

import com.gem.server.utils.Constants;
import com.gem.server.dao.DealerDao;
import com.gem.server.model.*;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */

@Configuration
@PropertySource("classpath:config.properties")
public class DealerDaoImpl extends GenericDaoImpl<Dealer> implements DealerDao {
    @Autowired
    Environment env;
    private int dealerPageSize;
    private String dealerOrderAttribute;

    public DealerDaoImpl() {
        super(Dealer.class);
    }

    public List<Product> getProducts(Integer dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getProducts());
        List<Product> products = new ArrayList<Product>(dealer.getProducts());
        return products;
    }

    public List<Dealer> getDealers(int startIndex) {
        dealerPageSize = Integer.parseInt(env.getProperty(Constants.DEALER.page_size));
        dealerOrderAttribute = env.getProperty(Constants.DEALER.order);
        Criteria criteria = getSession().createCriteria(Dealer.class);
        criteria.addOrder(Order.asc(dealerOrderAttribute));
        criteria.setMaxResults(dealerPageSize);
        criteria.add(Restrictions.gt(dealerOrderAttribute, startIndex));
        return (List<Dealer>) criteria.list();
    }

    public List<Product> getProducts(int dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getProducts());
        List<Product> products = new ArrayList<Product>(dealer.getProducts());
        return products;
    }

    public List<Inventory> getInventories(int dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getInventories());
        List<Inventory> inventories = new ArrayList<Inventory>(dealer.getInventories());
        return inventories;
    }

    public List<Staff> getStaffs(int dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getStaffs());
        List<Staff> staffs = new ArrayList<Staff>(dealer.getStaffs());
        return staffs;

    }

    public List<Sale> getSales(int dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getSales());
        List<Sale> sales = new ArrayList<Sale>(dealer.getSales());
        return sales;
    }



}
