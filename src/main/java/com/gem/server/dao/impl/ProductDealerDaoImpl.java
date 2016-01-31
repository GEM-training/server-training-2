package com.gem.server.dao.impl;

import com.gem.server.dao.ProductDealerDao;
import com.gem.server.model.ProductDealer;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
@Transactional
public class ProductDealerDaoImpl extends GenericDaoImpl<ProductDealer> implements ProductDealerDao {
    public ProductDealerDaoImpl() {
        super(ProductDealer.class);
    }
}
