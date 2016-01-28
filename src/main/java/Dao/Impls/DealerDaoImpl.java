package Dao.Impls;

import Dao.AbstractDao;
import Dao.DealersDao;
import Models.Dealer;
import Models.Staff;
import Utils.Constants;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
@Configuration
@PropertySource("classpath:Config.properties")
@Transactional
public class DealerDaoImpl extends AbstractDao implements DealersDao {
    @Autowired
    Environment env;

    public List<Dealer> getAllDealers() {
        Criteria criteria = getSession().createCriteria(Dealer.class);
        return (List<Dealer>) criteria.list();

    }

    public Integer save(Dealer dealer) {
        return (Integer) getSession().save(dealer);
    }

    public void delete(Integer id) {
        Dealer dealer = getSession().load(Dealer.class, id);
        if (dealer != null)
            getSession().delete(dealer);
    }


    public Dealer findById(Integer id) {
        return getSession().get(Dealer.class, id);
    }

    public List<Dealer> getDealer(int startIndex) {
        Criteria criteria = getSession().createCriteria(Dealer.class);
        String propertyOrder = env.getProperty(Constants.DEALER.ORDER_ATTRIBUTE);
        System.out.print(Constants.DEALER.ORDER_ATTRIBUTE+ "  "+ Constants.DEALER.ORDER_ATTRIBUTE);
        int pageSize = Integer.parseInt(env.getProperty(Constants.DEALER.PAGE_SIZE));
        criteria.addOrder(Order.asc(propertyOrder));
        criteria.setMaxResults(3);
        criteria.add(Restrictions.gt(propertyOrder, startIndex));
        return (List<Dealer>) criteria.list();
    }


}
