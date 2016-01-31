package com.gem.server.dao.impl;

import com.gem.server.Utils.Constants;
import com.gem.server.dao.SaleDao;
import com.gem.server.model.Sale;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
@Transactional
@Configuration
@PropertySource("classpath:config.properties")

public class SaleDaoImpl extends GenericDaoImpl<Sale> implements SaleDao {
    @Autowired
    Environment env;

    private String propertyOrderSale;
    private int salePageSize;

    public SaleDaoImpl() {
        super(Sale.class);
    }

    public List<Sale> getSales(int startIndex) {
        Criteria criteria = getSession().createCriteria(Sale.class);
        propertyOrderSale = env.getProperty(Constants.SALE.order);
        salePageSize = Integer.parseInt(Constants.SALE.page_size);
        criteria.addOrder(Order.asc(propertyOrderSale));
        criteria.setMaxResults(salePageSize);
        criteria.add(Restrictions.gt(propertyOrderSale, startIndex));
        return (List<Sale>) criteria.list();
    }

}
