package Controllers;

import Dao.DealersDao;
import Dao.ProductDao;
import Dao.ProductDealerDao;
import Models.Dealer;
import Models.Product;
import Models.ProductDealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoapham on 19/01/2016.
 */
@RestController
@RequestMapping("/product-deal")
@Transactional
public class ProductDealerController {
    @Autowired
    ProductDealerDao productDealerDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    DealersDao dealersDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListMakes() {
        return "" + productDealerDao.getAllProductDeals().size();
    }

    @RequestMapping(value = "/add-one")
    public String addOneProductDeal() {
        ProductDealer productDealer = new ProductDealer();
        Product product = productDao.findById(0);
        Dealer dealer = dealersDao.findById(0);
        productDealer.setProductId(product.getProductId());
        productDealer.setDealerId(dealer.getDealerId());
        productDealer.setPrice(100000);

        return "Result: " + productDealerDao.save(productDealer);

    }
}
