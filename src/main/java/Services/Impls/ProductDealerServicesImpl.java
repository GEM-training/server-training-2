package Services.Impls;

import Dao.ProductDealerDao;
import Models.ProductDealer;
import Services.ProductDealerServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public class ProductDealerServicesImpl implements ProductDealerServices{
    @Autowired
    ProductDealerDao productDealerDao;
    public List<ProductDealer> getAllProductDealers() {
        return productDealerDao.getAllProductDeals();
    }

    public Integer save(ProductDealer productDealer) {
        return productDealerDao.save(productDealer);
    }

    public void delete(Integer productDealerId) {
        productDealerDao.delete(productDealerId);

    }

    public ProductDealer findById(Integer productDealerId) {
        return productDealerDao.findById(productDealerId);
    }
}
