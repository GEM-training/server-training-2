package com.gem.server.service;

import com.gem.server.model.Dealer;
import com.gem.server.model.Inventory;
import com.gem.server.model.Product;
import com.gem.server.model.ResponseObject;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface DealerService{

    ResponseObject findById(Integer id);

    ResponseObject findAll();

    ResponseObject save(Dealer dealer);

    ResponseObject update(Dealer dealer);

    ResponseObject delete(Dealer dealer);

    ResponseObject deleteById(Integer dealerId);

    ResponseObject getDealers(int startIndex);

    ResponseObject getProducts(Integer dealerId);

    ResponseObject getInventories(Integer dealerId);

    ResponseObject getSales(Integer dealerId);

    ResponseObject getStaffs(Integer dealerId);
}
