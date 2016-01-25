package Controllers;

import Dao.MakesDao;
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
    MakesDao makesDao;

    @RequestMapping(value = "/list")
    public String listMakes(){
        return ""+makesDao.getAllMakes().size();
    }

    @RequestMapping(value = "/add-one")
    public String addOneMake(){
        Make make = new Make();
        make.setName("Make demo no "+makesDao.getAllMakes().size());
        makesDao.save(make);
        return "Successful";
    }
}
