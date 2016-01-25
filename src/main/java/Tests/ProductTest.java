package Tests;

import Models.Product;
import Services.ProductServices;
import junit.framework.TestCase;
import org.hibernate.Hibernate;
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
@ContextConfiguration(locations = { "/META-INF/dispatcher-servlet.xml" })
@Transactional
@Configuration
public class ProductTest extends TestCase{
    @Autowired
    ProductServices productServices;
    @Test
    public void addProduct(){
        Product product = new Product();
        assertEquals(new Integer(8),productServices.save(product));
    }
    @Test
    public void dataTest(){
        Product product =productServices.findById(3);
        assertEquals(product.getName(),"Wave Alpha");
    }

    @Test
    public void constraintDealersTest(){
        Product product =productServices.findById(3);
        Hibernate.initialize(product.getListDealers());
        assertEquals(1,product.getListDealers().size());
    }
    @Test
    public void constraintInventoriesTest(){
        Product product =productServices.findById(3);
        assertEquals(1,product.getListInventories().size());
    }
    @Test
    public void constraintSaleTest(){
        Product product =productServices.findById(3);
        assertEquals(1,product.getListSales().size());
    }
    @Test
    public void deleteProductFalse(){
        assertEquals(false,productServices.delete(100));
    }
    @Test
    public void deleteProductTrue(){
        assertEquals(true,productServices.delete(1));
    }
}
