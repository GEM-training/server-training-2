package Services;

import Models.ProductDealer;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface ProductDealerServices {
    List<ProductDealer> getAllProductDealers();

    Integer save(ProductDealer productDealer);

    void delete(Integer productDealerId);

    ProductDealer findById(Integer productDealerId);

}
