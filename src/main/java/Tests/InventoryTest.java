package Tests;

import Models.Dealer;
import Models.Inventory;
import Services.InventoryServices;
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
 * Created by nguyenkhoi on 1/25/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/dispatcher-servlet.xml"})
@Transactional
@Configuration
public class InventoryTest extends TestCase {
    @Autowired
    InventoryServices inventoryServices;

    @Test
    public void testAddInventory() {
        Inventory inventory = new Inventory();
        assertEquals(new Integer(55), inventoryServices.save(inventory));
    }

    @Test
    public void testDeleteInventory() {
        assertEquals(true, inventoryServices.delete(7));
    }

    @Test
    public void testFindInventory() {
        assertEquals("Kho Bắc Ninh", inventoryServices.findById(8).getName());
    }
    @Test
    public void getDealerFromInventory() {
        Dealer dealer = inventoryServices.findById(7).getDealer();
        assertEquals(1, dealer.getDealerId());

    }

}
