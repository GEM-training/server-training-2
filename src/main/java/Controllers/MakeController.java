package Controllers;

import Dao.MakeDao;
import Dao.StaffDao;
import Models.Make;
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
    MakeDao makeDao;

    @Autowired
    StaffDao staffDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListMakes() {
        return makeDao.getAllMakes().toString();
    }

    @RequestMapping(value = "/add-one")
    public String addOneMake() {
        Make make = new Make();
        make.setName("Make demo no " + makeDao.getAllMakes().size());
        makeDao.save(make);
        return "Successful";
    }

    @RequestMapping(value = "/delete/{makeId}")
    public String deleteMake(@PathVariable("makeId") Integer makeId) {
//        makeDao.delete(makeId);
        return "Deleted!";
    }

    @RequestMapping(value = "/get-products/{makeId}")
    public String getBill(@PathVariable("makeId")Integer makeId){
        return makeDao.findById(makeId).getSetProducts().toString();
    }
}
