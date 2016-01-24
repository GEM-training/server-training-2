package Tests;

import Models.*;
import Services.DealerServices;
import Services.ProductDealerServices;
import Services.ProductServices;
import Services.StaffServices;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by phong on 1/24/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class ProductDealerTest extends TestCase {
    @Autowired
    ProductServices productServices;
    @Autowired
    DealerServices dealerServices;
    @Autowired
    ProductDealerServices productDealerServices;

    public int createProductDealer() {
        Dealer dealer = dealerServices.getAllDealers().get(0);
        Product product = productServices.getAllProducts().get(0);
        ProductDealer productDealer = new ProductDealer();
        productDealer.setProductDealerId(100);
        productDealer.setDealerId(dealer.getDealerId());
        productDealer.setProductId(product.getProductId());
        return productDealerServices.save(productDealer);
    }

    //join 2 table
    //
    public int getDealerFromProductDealer(int productDealerId) {
        ProductDealer productDealer = productDealerServices.findById(productDealerId);
        return productDealer.getDealerId();

    }

    // join 3 tables
    //get make from product dealer
    public int getMakeFromProductDealer(int productDealerId) {
        ProductDealer productDealer = productDealerServices.findById(productDealerId);
        int productId = productDealer.getProductId();
        Product product = productServices.findById(productId);
        Make make = product.getMake();
        return make.getMakeId();


    }

    @Test
    public void testProductDealerTable() {
        assertEquals(100, createProductDealer());

    }

    @Test
    public void test1ProductDealerTable() {

        assertEquals(0, getDealerFromProductDealer(100));


    }

    @Test
    public void test2ProductDealerTable() {


        assertEquals(10, getMakeFromProductDealer(100));

    }


}
