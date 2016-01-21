package Controllers;

import Dao.SaleDetailDao;
import Models.Sale;
import Models.SaleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/saleDetail")
@Transactional

public class SaleDetailController {
    @Autowired
    SaleDetailDao saleDetailDao;

    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public String getListSaleDetail(){
            return ""+saleDetailDao.getAllSaleDetails();
        }

    @RequestMapping(value = "/add-one")
    public String addOneSaleDetail(){
        SaleDetail saleDetail = new SaleDetail();
        saleDetailDao.save(saleDetail);
        return "Successful";
    }

    @RequestMapping(value = "/delete-one")
    public void delete(){
        SaleDetail SaleDetail = new SaleDetail();
        saleDetailDao.delete(1);
    }

    @RequestMapping(value = "/find-one")
    public Sale findSaleDetail(){
        return saleDetailDao.findById(1).getSale();
    }
}
