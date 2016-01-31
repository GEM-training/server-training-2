package com.gem.server.dao.impl;

import com.gem.server.Utils.Constants;
import com.gem.server.dao.InventoryDao;
import com.gem.server.model.Inventory;
import com.gem.server.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
@Configuration
@PropertySource("classpath:Config.properties")
public class InventoryDaoImpl extends GenericDaoImpl<Inventory> implements InventoryDao {
    @Autowired
    Environment env;
    private int pageSize;
    private String propertyOrder;

    public InventoryDaoImpl() {
        super(Inventory.class);
    }

    public List<Inventory> getInventory(int startIndex) {
        propertyOrder = env.getProperty(Constants.INVENTORY.ORDER_ATTRIBUTE);
        pageSize = Integer.parseInt(env.getProperty(Constants.INVENTORY.PAGE_SIZE));
        Criteria criteria = getSession().createCriteria(Inventory.class);
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        criteria.setMaxResults(pageSize);
        return (List<Inventory>) criteria.list();
    }

    public Set<Product> getProducts(Integer inventoryId) {
        Inventory inventory = findById(inventoryId);
        Hibernate.initialize(inventory.getListProducts());
        return inventory.getListProducts();
    }
}
