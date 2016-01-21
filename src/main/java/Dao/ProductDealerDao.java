package Dao;

import Models.Make;
import Models.ProductDealer;


import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
public interface Product_dealerDao {
    public List<ProductDealer> getAllProduct();
    public Integer save(ProductDealer product_dealer);
    public void deleteProduct_dealer(Integer id);
    public ProductDealer findById(Integer id);
}
