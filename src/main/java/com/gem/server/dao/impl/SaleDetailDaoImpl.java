package com.gem.server.dao.impl;

import com.gem.server.Utils.Constants;
import com.gem.server.dao.SaleDetailDao;
import com.gem.server.model.Sale;
import com.gem.server.model.SaleDetail;
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
public class SaleDetailDaoImpl extends GenericDaoImpl<SaleDetail> implements SaleDetailDao {
    @Autowired
    Environment env;

    private String propertyOrderSaleDetail;
    private int staffDetailageSize;

    public SaleDetailDaoImpl() {
        super(SaleDetail.class);
    }

    public List<SaleDetail> getSaleDetails(int startIndex) {
        propertyOrderSaleDetail = env.getProperty(Constants.SALE_DETAIL.order);
        staffDetailageSize = Integer.parseInt(Constants.SALE_DETAIL.page_size);
        Criteria criteria = getSession().createCriteria(Sale.class);
        criteria.addOrder(Order.asc(propertyOrderSaleDetail));
        criteria.setMaxResults(staffDetailageSize);
        criteria.add(Restrictions.gt(propertyOrderSaleDetail, startIndex));
        return (List<SaleDetail>) criteria.list();
    }
}
