package com.gem.server.service;

import com.gem.server.model.Sale;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleService {
    List<Sale> getAllSales();

    List<Sale> getSales(int startIndex);

    Integer save(Sale sale);

    boolean delete(Integer saleId);

    Sale findById(Integer saleId);
}
