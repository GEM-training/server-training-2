package Controllers;

import Dao.ProductDao;
import Dao.ProductDealerDao;
import Models.Product;
import org.hibernate.Hibernate;
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

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId") Integer productId) {
        productDao.delete(productId);
        return "Products quantity: " + productDao.getAllProducts().size() + "--------------product_dealer: " + productDealerDao.getAllProductDeals().size();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProducts() {
        return productDao.getAllProducts().toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addProduct() {
        productDao.save(new Product());
    }

    @RequestMapping(value = "/list-parts/{productId}")
    public String getListParts(@PathVariable("productId") Integer productId) {
        return productDao.findById(productId).getListParts().toString();
    }

    @RequestMapping(value = "/find/{productId}")
    public String getProduct(@PathVariable("productId") Integer productId) {
        return productDao.findById(productId).toString();
    }

    @RequestMapping(value = "/getDealers/{productId}")
    public String getDealers(@PathVariable("productId") Integer productId) {
        Product product = productDao.findById(productId);
        return product.getListDealers().toString();
    }

    @RequestMapping(value = "/getInventories/{productId}")
    public String getInventories(@PathVariable("productId") Integer productId) {
        return productDao.findById(productId).getListInventories().toString();
    }
}
