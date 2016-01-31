package com.gem.server.service;

import com.gem.server.model.*;

import java.util.List;
import java.util.Set;

/**
 * Created by hoak57uet on 1/21/16.
 */
public interface ProductService {
    ResponseObject findById(Integer id);

    ResponseObject findAll();

    ResponseObject save(Product product);

    ResponseObject update(Product product);

    ResponseObject delete(Product product);

    ResponseObject deleteById(Integer productId);

    ResponseObject getProducts(int startIndex);

    ResponseObject getDealers(Integer productId);

    ResponseObject getMake(Integer productId);

    ResponseObject getSales(Integer productId);

    ResponseObject getParts(Integer productId);
}
