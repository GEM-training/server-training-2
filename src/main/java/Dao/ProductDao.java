package Dao;

import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
public interface ProductDao {
    List<Product> getAllProducts();

    Product findById(Integer productId);

    Integer save(Product product);

    void saveOrUpdate(Product product);

    void delete(Integer productId);

    Set<Dealer> getDealers(Integer productId);

    Set<Product> getParts(Integer productId);

    Make getMake(Integer productId);

    Set<Sale> getSales(Integer productId);

}
