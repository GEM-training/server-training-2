package Dao;

import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SaleDao {
    List<Sale> getAllSales();

    Integer save(Sale sale);

    void delete(Integer saleId);

    Sale findById(Integer saleId);
    //public List<SaleDetail> getAllSaleDetails(Integer saleId);
}
