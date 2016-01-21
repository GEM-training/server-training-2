package Controllers;

import Dao.ProductDao;
import Dao.ProductDealerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoapham on 20/01/2016.
 */
@RestController
@Transactional
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductDealerDao productDealerDao;
    @RequestMapping(value = "/delete/{productId}",method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId")Integer productId){
        productDao.delete(productId);
        return "Products quantity: "+productDao.getAllProducts().size()+"--------------product_dealer: "+productDealerDao.getAllProductDeals().size();
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getProductDealer(){
        return  "Products quantity: "+productDao.getAllProducts().size()+"--------------product_dealer: "+productDealerDao.getAllProductDeals().size();
    }


}
