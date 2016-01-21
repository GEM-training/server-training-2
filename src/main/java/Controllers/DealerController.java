package Controllers;

import Dao.DealersDao;
import Models.Dealer;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/dealer")
@Transactional
public class DealerController {
    @Autowired
    DealersDao dealersDao;

    @RequestMapping(value = "/list")
    public String getAllDeals() {
        return dealersDao.getAllDealers().toString();
    }

    @RequestMapping(value = "/add-one")
    public String addOneDealer() {
        Dealer dealer = new Dealer();
        dealer.setAddress("10000 PNt");
        dealer.setDescription("No description");
        return "Result" + dealersDao.save(dealer);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteDealer(@PathVariable("id") int id) {
        dealersDao.delete(id);
        return "Delete";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDealById(@PathVariable("id") int id) {
        Dealer dealer = dealersDao.findById(id);

        return dealer.getName() + ", " + dealer.getAddress() + " have " + dealer.getListSales().size();

    }


}
