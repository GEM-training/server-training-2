package Services.Impls;

import Dao.ProductDao;
import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;
import Services.ProductServices;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by hoak57uet on 1/21/16.
 */
public class ProductServicesImpl implements ProductServices {
    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Product> getProducts(int startIndex) {
        return productDao.getProduct(startIndex);
    }

    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }

    public Integer save(Product product) {
        return productDao.save(product);
    }

    public void saveOrUpdate(Product product) {
        productDao.saveOrUpdate(product);
    }

    public void delete(Integer productId) {
        productDao.delete(productId);
    }

    public Set<Dealer> getDealers(Integer productId) {
        return productDao.getDealers(productId);
    }

    public Make getMake(Integer productId) {
        return productDao.getMake(productId);
    }

    public Set<Sale> getSales(Integer productId) {
        return productDao.getSales(productId);
    }

    public Set<Product> getParts(Integer productId) {
        return productDao.getParts(productId);
    }
}
