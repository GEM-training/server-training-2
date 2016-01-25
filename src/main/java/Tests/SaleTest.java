package Tests;

import Models.Customer;
import Models.Sale;
import Services.CustomerServices;
import Services.SaleServices;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jojo on 25/01/2016.
 */
public class SaleTest extends TestCase {
    @Autowired
    SaleServices saleServices;
    /*@Autowired
    DealerServices dealerServices;
    @Autowired
    ProductDealerServices productDealerServices;*/

    @Test
    public void testCreateSale(){
        Sale sale = new Sale();
        sale.setSaleId(2);
        sale.setStatus(0);
        assertEquals((Integer)2, saleServices.save(sale));
    }

    @Test
    public void testDeleteSale(){
        assertEquals(true, saleServices.delete(1));
    }

    @Test
    public void testFindSale(){
        assertEquals(1, saleServices.findById(1).getStatus());
    }
}
