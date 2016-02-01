package com.gem.server.service;

import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleService {
    ResponseObject findAll();

    ResponseObject getSales(int startIndex);

    ResponseObject save(Sale sale);

    ResponseObject delete(Integer saleId);

    ResponseObject findById(Integer saleId);

    ResponseObject getSaleDetail(Integer saleId);
}
