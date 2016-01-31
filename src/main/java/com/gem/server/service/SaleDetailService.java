package com.gem.server.service;

import com.gem.server.model.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleDetailService {
    List<SaleDetail> getAllSaleDetails();

    List<SaleDetail> getSaleDetails(int startIndex);

    Integer save(SaleDetail saleDetail);

    boolean delete(Integer saleDetailId);

    SaleDetail findById(Integer saleDetailId);
}
