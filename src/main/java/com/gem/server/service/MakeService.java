package com.gem.server.service;

import com.gem.server.model.Make;
import com.gem.server.model.Product;
import com.gem.server.model.ResponseObject;

/**
 * Created by hoak57uet on 1/21/16.
 */
public interface MakeService {
    ResponseObject findById(Integer id);

    ResponseObject findAll();

    ResponseObject save(Make make);

    ResponseObject update(Make make);

    ResponseObject delete(Make make);

    ResponseObject deleteById(Integer makeId);

    ResponseObject getMakes(int start);

    ResponseObject getProducts(Integer makeId);
}
