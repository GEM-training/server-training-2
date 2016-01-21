package Dao.Impls;

import Dao.AbstractDao;
import Dao.DealersDao;
import Models.Dealer;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public class DealerDaoImpl extends AbstractDao implements DealersDao {
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
        return getSession().get(Dealer.class,id);
    }


}
