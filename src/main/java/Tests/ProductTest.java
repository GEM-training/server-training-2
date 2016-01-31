package Tests;

import com.gem.server.dao.ProductDao;
import com.gem.server.model.Product;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hoapham on 25/01/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class ProductTest extends TestCase {
    @Autowired
    ProductDao productDao;

    @Test
    public void addProduct() {
        Product product = new Product();
        assertEquals(new Integer(8), productDao.save(product));
    }

    @Test
    public void dataTest() {
        Product product = productDao.findById(3);
        assertEquals(product.getName(), "Wave Alpha");
    }

    @Test
    public void constraintDealersTest() {
        Product product = productDao.findById(3);
        assertEquals(1, product.getListDealers().size());
    }

    @Test
    public void constraintInventoriesTest() {
        Product product = productDao.findById(3);
        assertEquals(1, product.getListInventories().size());
    }

    @Test
    public void constraintSaleTest() {
        Product product = productDao.findById(3);
        assertEquals(0, product.getListSales().size());
    }

    @Test
    public void testPrimaryKey(){
        Product product = new Product();
        product.setProductId(2);
        product.setName("Test-product-primary key");
        assertEquals(new Integer(46),productDao.save(product));
    }
}
