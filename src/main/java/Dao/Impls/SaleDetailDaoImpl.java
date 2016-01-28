package Dao.Impls;

import Dao.AbstractDao;
import Dao.SaleDetailDao;
import Models.Sale;
import Models.SaleDetail;
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
public class SaleDetailDaoImpl extends AbstractDao implements SaleDetailDao {
    @Autowired
    Environment env;

    public List<SaleDetail> getAllSaleDetails() {
        Criteria criteria = getSession().createCriteria(SaleDetail.class);
        return (List<SaleDetail>) criteria.list();
    }

    public List<SaleDetail> getSaleDetailss(int startIndex){
        Criteria criteria = getSession().createCriteria(Sale.class);
        String propertyOrder = env.getProperty(Constants.SALE_DETAIL.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(Constants.SALE_DETAIL.PAGE_SIZE);
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(pageSize);criteria.add(Restrictions.gt(propertyOrder, startIndex));
        return (List<SaleDetail>) criteria.list();
    }

    public Integer save(SaleDetail saleDetail) {
        return (Integer) getSession().save(saleDetail);
    }

    public void delete(Integer saleDetailId) {
        SaleDetail SaleDetail = getSession().load(SaleDetail.class, saleDetailId);
        if (SaleDetail != null) {
            getSession().delete(SaleDetail);
        }
    }

    public SaleDetail findById(Integer saleDetailId) {
        return getSession().get(SaleDetail.class, saleDetailId);
    }
}
