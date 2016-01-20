package Dao;

import Models.Make;
import Models.Product_dealer;

import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
public interface Product_dealerDao {
    public List<Product_dealer> getAllProduct_dealer();
    public Integer save(Product_dealer product_dealer);
    public void deleteProduct_dealer(Integer id);
    public Product_dealer findById(Integer id);
}
