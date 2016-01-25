package Tests;

import Models.Make;
import Services.MakeServices;
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
public class MakeTest extends TestCase{
    @Autowired
    MakeServices makeServices;
    @Test
    public void dataTest(){
        Make make = makeServices.findById(2);
        assertEquals("LG",make.getName());
    }

    @Test
    public void testContrainstProducts(){
        Make make = makeServices.findById(2);
        assertEquals(7,make.getSetProducts().size());
    }
}
