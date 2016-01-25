package Controllers;

import Dao.ProductDealerDao;
import Models.Dealer;
import Models.Product;
import Services.MakeServices;
import Services.ProductServices;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
@RestController
@Transactional
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServices productServices;
    @Autowired
    ProductDealerDao productDealerDao;
    @Autowired
    MakeServices makeServices;

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId") Integer productId) {
        productServices.delete(productId);
        return "Products quantity: " + productServices.getAllProducts().size() + "--------------product_dealer: " + productDealerDao.getAllProductDeals().size();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(productServices.getAllProducts(),HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addProduct() {
        Product product = new Product();
        product.setProductId(2);
        product.setName("test-primary-key-with-2");
        product.setMake(makeServices.findById(1));
        product.setCreatedDate(new Date(System.currentTimeMillis()));
        product.setUpdatedDate(new Date(System.currentTimeMillis()));
        productServices.save(product);
    }

    @RequestMapping(value = "/list-parts/{productId}")
    public String getListParts(@PathVariable("productId") Integer productId) {
        return productServices.findById(productId).getListParts().toString();
    }

    @RequestMapping(value = "/find/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") Integer productId) {
            Product product = productServices.findById(productId);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }

    @RequestMapping(value = "/getDealers/{productId}")
    public ResponseEntity<List<Dealer>> getDealers(@PathVariable("productId") Integer productId) {
        Product product = productServices.findById(productId);
        List<Dealer>dealers = new ArrayList<Dealer>();
        dealers.addAll(product.getListDealers());
        return new ResponseEntity<List<Dealer>>(dealers,HttpStatus.OK);
    }

    @RequestMapping(value = "/getInventories/{productId}")
    public String getInventories(@PathVariable("productId") Integer productId) {
        return productServices.findById(productId).getListInventories().toString();
    }
}
