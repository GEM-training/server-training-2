package com.gem.server.service;

import com.gem.server.model.ResponseObject;
import com.gem.server.model.Sale;
import com.gem.server.model.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleDetailService {
    ResponseObject findAll();

    ResponseObject getSaleDetails(int startIndex);

    ResponseObject save(SaleDetail saleDetail);

    ResponseObject update(SaleDetail saleDetail);

    ResponseObject delete(Integer saleDetailId);

    ResponseObject findById(Integer saleDetailId);
}
