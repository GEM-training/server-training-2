package Dao;

import Models.ProductDealer;

import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
public interface ProductDealerDao {
    List<ProductDealer> getAllProductDeals();

    Integer save(ProductDealer product_dealer);

    void delete(Integer id);

    ProductDealer findById(Integer id);
}
