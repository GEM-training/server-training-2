package com.gem.server.service.impl;

import com.gem.server.dao.ProductDealerDao;
import com.gem.server.model.ProductDealer;
import com.gem.server.service.ProductDealerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public class ProductDealerServiceImpl implements ProductDealerService {
    @Autowired
    ProductDealerDao productDealerDao;


    public List<ProductDealer> getAllProductDealers() {
        return productDealerDao.findAll();
    }

    public Integer save(ProductDealer productDealer) {
        return productDealerDao.save(productDealer);
    }

    public void delete(Integer productDealerId) {
        productDealerDao.deleteById(productDealerId);

    }

    public ProductDealer findById(Integer productDealerId) {
        return productDealerDao.findById(productDealerId);
    }
}
