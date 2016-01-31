package com.gem.server.dao.impl;

import com.gem.server.Utils.Constants;
import com.gem.server.dao.DealerDao;
import com.gem.server.model.Dealer;
import com.gem.server.model.Inventory;
import com.gem.server.model.Product;
import com.gem.server.model.Sale;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
@Configuration
@PropertySource("classpath:Config.properties")
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

    public List<Dealer> getDealer(int startIndex) {
        dealerPageSize = Integer.parseInt(env.getProperty(Constants.DEALER.PAGE_SIZE));
        dealerOrderAttribute = env.getProperty(Constants.DEALER.ORDER_ATTRIBUTE);
        Criteria criteria = getSession().createCriteria(Dealer.class);
        criteria.addOrder(Order.asc(dealerOrderAttribute));
        criteria.setMaxResults(dealerPageSize);
        criteria.add(Restrictions.gt(dealerOrderAttribute, startIndex));
        return (List<Dealer>) criteria.list();
    }

    public List<Inventory> getInventories(Integer dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getInventories());
        List<Inventory> inventories = new ArrayList<Inventory>(dealer.getInventories());
        return inventories;
    }

    public List<Sale> getSales(Integer dealerId) {
        Dealer dealer = findById(dealerId);
        Hibernate.initialize(dealer.getInventories());
        List<Sale> sales = new ArrayList<Sale>(dealer.getSales());
        return sales;
    }
}
