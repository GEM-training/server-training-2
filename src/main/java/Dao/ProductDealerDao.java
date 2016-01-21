package Dao;

import Models.ProductDealer;

import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
public interface ProductDealerDao {
    public List<ProductDealer> getAllProductDeals();

    public Integer save(ProductDealer product_dealer);

    public void delete(Integer id);

    public ProductDealer findById(Integer id);
}
