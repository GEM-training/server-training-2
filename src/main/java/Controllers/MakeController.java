package Controllers;

import Dao.MakeDao;
import Models.Make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoapham on 19/01/2016.
 */
@RestController
@RequestMapping("/make")
@Transactional
public class MakeController {
    @Autowired
    MakeDao makeDao;

    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public String getListMakes(){
        return ""+makeDao.getAllMakes();
    }

    @RequestMapping(value = "/add-one")
    public String addOneMake(){
        Make make = new Make();
        make.setName("Make demo no "+makeDao.getAllMakes().size());
        makeDao.save(make);
        return "Successful";
    }

}
