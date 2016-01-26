package Dao.Impls;

import Dao.AbstractDao;
import Dao.ProductDao;
import Models.Dealer;
import Models.Make;
import Models.Product;
import Models.Sale;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */

@Transactional
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    public List<Product> getAllProducts() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    public Product findById(Integer productId) {
        Product product = getSession().get(Product.class, productId);
        return  product;
    }

    public Integer save(Product product) {
        return (Integer) getSession().save(product);
    }

    public void delete(Integer productId) {
        Product product = getSession().get(Product.class, productId);
        getSession().delete(product);
    }

    public Set<Dealer> getDealers(Integer productId) {
        Product product = findById(productId);
        Hibernate.initialize(product.getListDealers());
        return product.getListDealers();
    }

    public Make getMake(Integer productId) {
        return findById(productId).getMake();
    }

    public Set<Sale> getSales(Integer productId) {
        Product product = findById(productId);
        Hibernate.initialize(product.getListSales());
        return product.getListSales();
    }

    public Set<Product> getParts(Integer productId) {
        Product product = findById(productId);
        Hibernate.initialize(product.getListParts());
        return product.getListParts();
    }
}
