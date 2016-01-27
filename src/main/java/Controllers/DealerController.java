package Controllers;

import Dao.DealersDao;
import Models.Dealer;
import Services.DealerServices;
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
@RequestMapping("/api/dealer")
@Transactional
public class DealerController {
    @Autowired
    DealerServices dealerServices;

    @RequestMapping(value = "/list")
    public String getAllDeals() {
        return dealerServices.getAllDealers().toString();
    }

    @RequestMapping(value = "/add-one")
    public String addOneDealer() {
        Dealer dealer = new Dealer();
        dealer.setAddress("10000 PNt");
        dealer.setDescription("No description");
        return "Result" + dealerServices.save(dealer);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteDealer(@PathVariable("id") int id) {
        dealerServices.delete(id);
        return "Delete";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDealById(@PathVariable("id") int id) {
        Dealer dealer = dealerServices.findById(id);

        return dealer.getName() + ", " + dealer.getAddress() + " have " + dealer.getListSales().size();

    }


}
