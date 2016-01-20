package Dao;

import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public interface SalesDao {
    public List<Sale> getAllMakes();
    public Integer save(Sale sale);
    public void deleteSale(Integer saleId);
    public Sale findById(Integer saleId);
}
