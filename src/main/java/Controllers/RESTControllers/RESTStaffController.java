package Controllers.RESTControllers;

import Dao.DealersDao;
import Dao.StaffDao;
import Models.Dealer;
import Models.ResponseObject;
import Models.Staff;
import Services.DealerServices;
import Services.StaffServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/api/staff")
@Transactional
public class RESTStaffController {
    @Autowired
    StaffServices staffServices;


    @RequestMapping(value = "/list")
    public
    @ResponseBody
    ResponseObject getAllStaffs() {
        try {
            List<Staff> staffs = staffServices.getAllStaffs();
            return new ResponseObject(true, Constants.HTTP.SUCCESS, staffs);
        } catch (Exception e){
            return  new ResponseObject(false,e.getMessage(),null );
        }

    }

    @RequestMapping(value = "/add-one")
    public
    @ResponseBody
    ResponseObject addOneStaff(@RequestBody Staff staff) {
        try{
            Integer staffId = staffServices.save(staff);
            return new ResponseObject(true, Constants.HTTP.SUCCESS,staff);
        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);


        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteStaff(@RequestParam("staffId") int staffId ) {
        try {
            staffServices.delete(staffId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, staffId);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getStaffById(@PathVariable("id") int id) {
        try {
            Staff staff = staffServices.findById(id);
            return new ResponseObject(true,"",staff);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }



    }
}
