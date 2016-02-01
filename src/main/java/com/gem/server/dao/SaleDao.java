package com.gem.server.dao;

import com.gem.server.model.Sale;
import com.gem.server.model.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SaleDao extends GenericDao<Sale> {
    List<Sale> getSales(int startIndex);
    List<SaleDetail> getAllSaleDetail(int saleId);
}
