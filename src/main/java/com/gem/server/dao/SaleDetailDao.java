package com.gem.server.dao;

import com.gem.server.model.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SaleDetailDao extends GenericDao<SaleDetail> {
    List<SaleDetail> getSaleDetails(int startIndex);
}
