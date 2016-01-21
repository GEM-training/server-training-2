package Dao;

import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SaleDao {
    public List<Sale> getAllSales();

    public Integer save(Sale sale);

    public void delete(Integer saleId);

    public Sale findById(Integer saleId);
    //public List<SaleDetail> getAllSaleDetails(Integer saleId);
}
