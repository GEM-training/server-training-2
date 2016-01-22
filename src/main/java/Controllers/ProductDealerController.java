package Controllers;

import Models.Dealer;
import Models.Product;
import Models.ProductDealer;
import Services.DealerServices;
import Services.ProductDealerServices;
import Services.ProductServices;
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
    ProductDealerServices productDealerServices;
    @Autowired
    ProductServices productServices;
    @Autowired
    DealerServices dealerServices;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListMakes() {
        return "" + productDealerServices.getAllProductDealers().size();
    }

    @RequestMapping(value = "/add-one")
    public String addOneProductDeal() {
        ProductDealer productDealer = new ProductDealer();
        Product product = productServices.findById(0);
        Dealer dealer = dealerServices.findById(0);
        productDealer.setProductId(product.getProductId());
        productDealer.setDealerId(dealer.getDealerId());
        productDealer.setPrice(100000);

        return "Result: " + productDealerServices.save(productDealer);

    }
}
