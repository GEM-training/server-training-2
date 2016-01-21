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
    public List<Product> getAllProducts();

    public Product findById(Integer productId);

    public Integer save(Product product);

    public void delete(Integer productId);

    public List<Dealer> getDealers(Integer productId);

    public Make getMake(Integer productId);

    public List<Sale> getListSales(Integer productId);

}
