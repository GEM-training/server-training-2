package Dao;

import Models.Make;
import Models.Product_dealer;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
public class Product_dealerImpl extends AbstractDao implements Product_dealerDao {


    public List<Product_dealer> getAllProduct_dealer() {
        Criteria criteria = getSession().createCriteria(Product_dealer.class);
        return (List<Product_dealer>) criteria.list();
    }

    public Integer save(Product_dealer product_dealer) {
        return (Integer) getSession().save(product_dealer);
    }

    public void deleteProduct_dealer(Integer id) {
        Product_dealer product_dealer = getSession().load(Product_dealer.class,id);
        if(product_dealer!=null)
            getSession().delete(product_dealer);

    }



    public Product_dealer findById(Integer makeId) {
        return (Product_dealer) getObjectById(makeId);
    }

}
