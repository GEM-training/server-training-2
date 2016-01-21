package Dao;

import Models.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SaleDetailDao {
    List<SaleDetail> getAllSaleDetails();

    Integer save(SaleDetail saleDetail);

    void delete(Integer saleDetailId);

    SaleDetail findById(Integer saleDetailId);
}
