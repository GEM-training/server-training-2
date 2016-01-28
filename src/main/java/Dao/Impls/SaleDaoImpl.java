package Dao.Impls;

import Dao.AbstractDao;
import Dao.SaleDao;
import Models.Sale;
import Utils.Constants;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.env.Environment;
import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
@Transactional
@Configuration
@PropertySource("classpath:Config.properties")

public class SaleDaoImpl extends AbstractDao implements SaleDao {
    @Autowired
    Environment env;
    public List<Sale> getAllSales() {
        Criteria crt = getSession().createCriteria(Sale.class);
        return (List<Sale>) crt.list();
    }

    public List<Sale> getSales(int startIndex){
        Criteria criteria = getSession().createCriteria(Sale.class);
        String propertyOrder = env.getProperty(Constants.SALE.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(Constants.SALE.PAGE_SIZE);
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        return (List<Sale>) criteria.list();
    }

    public Integer save(Sale sale) {
        return (Integer) getSession().save(sale);
    }

    public void delete(Integer saleId) {
        Sale sale = getSession().load(Sale.class, saleId);
        if (sale != null) {
            getSession().delete(sale);
        }
    }


    public Sale findById(Integer saleId) {
        return getSession().get(Sale.class, saleId);
    }

}
