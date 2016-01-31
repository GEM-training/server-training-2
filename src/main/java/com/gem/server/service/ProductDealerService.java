package com.gem.server.service;

import com.gem.server.model.ProductDealer;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface ProductDealerService {
    List<ProductDealer> getAllProductDealers();

    Integer save(ProductDealer productDealer);

    void delete(Integer productDealerId);

    ProductDealer findById(Integer productDealerId);

}
