package Controllers;

import Dao.MakeDao;
import Dao.StaffDao;
import Models.Make;
import Services.MakeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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
    MakeServices makeServices;

    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public String getListMakes(){
        return makeServices.getAllMakes().toString();
    }

    @RequestMapping(value = "/add-one")
    public String addOneMake(){
        Make make = new Make();
        make.setName("Make demo no "+makeServices.getAllMakes().size());
        makeServices.save(make);
        return "Successful";
    }

    @RequestMapping(value = "/delete/{makeId}")
    public String deleteMake(@PathVariable("makeId")Integer makeId){
        makeServices.delete(makeId);
        return "deleted";
    }
}
