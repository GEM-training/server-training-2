package Dao;

import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;

import java.util.List;

/**
 * Created by hoapham on 20/01/2016.
 */
public interface ProductDao {
    List<Product> getAllProducts();

    Product findById(Integer productId);

    Integer save(Product product);

    void delete(Integer productId);

    List<Dealer> getDealers(Integer productId);

    Make getMake(Integer productId);

    List<Sale> getListSales(Integer productId);

}
