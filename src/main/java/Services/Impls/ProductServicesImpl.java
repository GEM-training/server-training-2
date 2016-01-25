package Services.Impls;

import Dao.ProductDao;
import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;
import Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hoak57uet on 1/21/16.
 */
public class ProductServicesImpl implements ProductServices {
    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }

    public Integer save(Product product) {
        return productDao.save(product);
    }

    public boolean delete(Integer productId) {
        try{
            productDao.delete(productId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Dealer> getDealers(Integer productId) {
        return productDao.getDealers(productId);
    }

    public Make getMake(Integer productId) {
        return productDao.getMake(productId);
    }

    public List<Sale> getListSales(Integer productId) {
        return productDao.getListSales(productId);
    }
}
