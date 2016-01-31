package com.gem.server.dao.impl;

import com.gem.server.dao.ProductInventoryDao;
import com.gem.server.model.Product;
import com.gem.server.model.ProductInventory;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nguyenkhoi on 1/20/16.
 */
@Transactional
public class ProductInventoryDaoImpl extends GenericDaoImpl<ProductInventory> implements ProductInventoryDao {

    public ProductInventoryDaoImpl() {
        super(ProductInventory.class);
    }
}
