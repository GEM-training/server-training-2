package Services;

import Models.Sale;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleServices {
    List<Sale> getAllSales();

    Integer save(Sale sale);

    boolean delete(Integer saleId);

    Sale findById(Integer saleId);
}
