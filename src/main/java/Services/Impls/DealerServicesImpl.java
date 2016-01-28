package Services.Impls;

import Dao.DealersDao;
import Models.Dealer;
import Models.Staff;
import Services.DealerServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public class DealerServicesImpl implements DealerServices {
    @Autowired
    DealersDao dealersDao;

    public List<Dealer> getAllDealers() {
        return dealersDao.getAllDealers();
    }

    public Integer save(Dealer dealer) {
        return dealersDao.save(dealer);
    }

    public boolean delete(Integer dealerId) {
        try {
            dealersDao.delete(dealerId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Dealer findById(Integer dealerId) {
        return dealersDao.findById(dealerId);
    }

    public List<Dealer> getDealers(int startIndex) {
        return dealersDao.getDealer(startIndex);
    }
}
