package Dao.Impls;

import Dao.AbstractDao;
import Dao.ProductDao;
import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by hoapham on 20/01/2016.
 */
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    public List<Product> getAllProducts() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    public Product findById(Integer productId) {
        return getSession().get(Product.class, productId);
    }

    public Integer save(Product product) {
        return (Integer) saveObject(product);
    }

    public void delete(Integer productId) {
        Product product = getSession().get(Product.class, productId);
        getSession().delete(product);
    }

    public List<Dealer> getDealers(Integer productId) {
        return (List<Dealer>) findById(productId).getListDealers();
    }

    public Make getMake(Integer productId) {
        return findById(productId).getMake();
    }

    public List<Sale> getListSales(Integer productId) {
        return (List<Sale>) findById(productId).getListSales();
    }

}
