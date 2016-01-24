package Tests;

import Models.Dealer;
import Models.Product;
import Models.ProductDealer;
import Services.DealerServices;
import Services.ProductDealerServices;
import Services.ProductServices;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by phong on 1/24/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/dispatcher-servlet.xml" })
@Transactional
@Configuration
public class DealerTest extends TestCase{
    @Autowired
    ProductServices productServices;
    @Autowired
    DealerServices dealerServices;
    @Autowired
    ProductDealerServices productDealerServices;

    public int  createDealer(){
        Dealer dealer = new Dealer();
        dealer.setDealerId(10);
        dealer.setName("Hello");
        dealer.setAddress("Vn");
        return  dealerServices.save(dealer);

    }

    @Test
    public void testDealerTable(){
        assertEquals(10,createDealer());
    }
}
