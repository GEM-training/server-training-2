package Controllers;

import Dao.SaleDao;
import Models.Sale;
import Services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/sale")
@Transactional
public class SaleController {
    @Autowired
    SaleServices saleServices;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListSale() {
        return "" + saleServices.getAllSales();
    }

    @RequestMapping(value = "/add-one")
    public String addOneSale() {
        Sale sale = new Sale();
        saleServices.save(sale);
        return "Successful";
    }

    @RequestMapping(value = "/delete-one")
    public void delete() {
        Sale customer = new Sale();
        saleServices.delete(1);
    }

    @RequestMapping(value = "/find-one")
    public String findCustomer() {
        return saleServices.findById(1).getCustomer().getName();
    }
}


