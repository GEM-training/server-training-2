package Controllers;

import Dao.Product_dealerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phong on 20/01/2016.
 */
@RestController
@RequestMapping("/product_deal")
@Transactional
public class Product_DealController {
    @Autowired
    Product_dealerDao product_dealerDao;


    @RequestMapping("/list")
    public String listProductDeals(){
        return  product_dealerDao.getAllProduct_dealer()
    }




}
