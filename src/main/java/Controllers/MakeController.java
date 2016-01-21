package Controllers;

import Dao.InventoryDao;
import Dao.MakesDao;
import Dao.ProductDao;
import Models.Make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoapham on 19/01/2016.
 */
@RestController
@RequestMapping("/make")
@Transactional
public class MakeController {
    @Autowired
    InventoryDao inventoryDao;

    @RequestMapping(value = "/list")
    public String listMakes(){
        return ""+inventoryDao.getAllInventory().get(0).getListProducts();
    }

    @RequestMapping(value = "/add-one")
    public String addOneMake(){
        return "";
    }
}
