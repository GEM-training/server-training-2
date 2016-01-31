package com.gem.server.dao.impl;

import com.gem.server.Utils.Constants;
import com.gem.server.dao.ProductDao;
import com.gem.server.model.Dealer;
import com.gem.server.model.Make;
import com.gem.server.model.Product;
import com.gem.server.model.Sale;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
@Configuration
@PropertySource("classpath:config.properties")
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {
    @Autowired
    Environment env;
    private String propertyOrderProduct;
    private int productPageSize;


    public ProductDaoImpl() {
        super(Product.class);
    }

    public List<Product> getProduct(int startIndex) {
        productPageSize = Integer.parseInt(env.getProperty(Constants.PRODUCT.page_size));
        propertyOrderProduct = env.getProperty(Constants.PRODUCT.order);
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.addOrder(Order.asc(propertyOrderProduct));
        criteria.setMaxResults(productPageSize);
        criteria.add(Restrictions.gt(propertyOrderProduct, startIndex));
        return (List<Product>) criteria.list();
    }

    public Set<Dealer> getDealers(Integer productId) {
        Product product = findById(productId);
        Hibernate.initialize(product.getListDealers());
        return product.getListDealers();
    }

    public Make getMake(Integer productId) {
        return findById(productId).getMake();
    }

    public Set<Sale> getSales(Integer productId) {
        Product product = findById(productId);
        Hibernate.initialize(product.getListSales());
        return product.getListSales();
    }

    public Set<Product> getParts(Integer productId) {
        Product product = findById(productId);
        Hibernate.initialize(product.getListParts());
        return product.getListParts();
    }
}
