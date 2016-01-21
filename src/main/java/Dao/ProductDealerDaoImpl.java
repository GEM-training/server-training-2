package Dao;

import Models.Make;
import Models.ProductDealer;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by phong on 19/01/2016.
 */
public class ProductDealerDaoImpl extends AbstractDao implements ProductDealerDao {


    public List<ProductDealer> getAllProductDeals() {
        Criteria criteria = getSession().createCriteria(ProductDealer.class);
        return (List<ProductDealer>) criteria.list();
    }

    public Integer save(ProductDealer product_dealer) {
        return (Integer) getSession().save(product_dealer);
    }

    public void deleteProductDealer(Integer id) {
        ProductDealer product_dealer = getSession().load(ProductDealer.class,id);
        if(product_dealer!=null)
            getSession().delete(product_dealer);

    }



    public ProductDealer findById(Integer makeId) {
        return (ProductDealer) getObjectById(makeId);
    }

}
