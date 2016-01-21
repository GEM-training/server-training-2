package Dao;

import Models.SaleDetail;
import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SaleDetailDao {
    public List<SaleDetail> getAllSaleDetails();
    public Integer save(SaleDetail saleDetail);
    public void deleteSaleDetail(Integer saleDetailId);
    public SaleDetail findById(Integer saleDetailId);
}
