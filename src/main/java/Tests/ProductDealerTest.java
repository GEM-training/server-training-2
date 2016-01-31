package Tests;

import com.gem.server.dao.DealerDao;
import com.gem.server.dao.ProductDao;
import com.gem.server.dao.ProductDealerDao;
import com.gem.server.model.Dealer;
import com.gem.server.model.Make;
import com.gem.server.model.Product;
import com.gem.server.model.ProductDealer;
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
@ContextConfiguration(locations = {"classpath:/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class ProductDealerTest extends TestCase {
    @Autowired
    ProductDao productDao;
    @Autowired
    DealerDao dealerDao;
    @Autowired
    ProductDealerDao productDealerDao;

    @Test
    public void addProductDealer() {
        Dealer dealer = dealerDao.findAll().get(0);
        Product product = productDao.findAll().get(0);
        ProductDealer productDealer = new ProductDealer();
        productDealer.setProductDealerId(100);
        productDealer.setDealerId(dealer.getDealerId());
        productDealer.setProductId(product.getProductId());
        assertEquals(new Integer(20), productDealerDao.save(productDealer));
    }

    //join 2 table
    //
    @Test
    public void getDealerFromProductDealer() {
        ProductDealer productDealer = productDealerDao.findById(1);
        assertEquals(1, productDealer.getDealerId());

    }

    // join 3 tables
    //get make from product dealer
    @Test
    public void getMakeFromProductDealer() {
        ProductDealer productDealer = productDealerDao.findById(1);
        int productId = productDealer.getProductId();
        Product product = productDao.findById(productId);
        Make make = product.getMake();
        assertEquals(5, make.getMakeId());


    }


}
