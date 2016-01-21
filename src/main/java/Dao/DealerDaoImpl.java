package Dao;

import Models.Customer;
import Models.Dealer;
import Models.Make;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public class DealerDaoImpl  extends AbstractDao implements  DealersDao{
    public List<Dealer> getAllDealers() {
        Criteria criteria = getSession().createCriteria(Dealer.class);
        return (List<Dealer>) criteria.list();

    }

    public Integer save(Dealer dealer) {
        return (Integer) getSession().save(dealer);
    }

    public void deleteDeal(Integer id) {
        Dealer dealer = getSession().load(Dealer.class, id);
        if (dealer != null)
            getSession().delete(dealer);

    }

    public Dealer findById(Integer id) {
        return getSession().get(Dealer.class,id);
    }


}
