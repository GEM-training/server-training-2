package RESTControllers;

import Models.Product;
import Models.ResponseObject;
import Models.Staff;
import Services.DealerServices;
import Services.StaffServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/api/staff")

public class RESTStaffController {
    @Autowired
    StaffServices staffServices;


    @RequestMapping(value = "/view-all")
    public
    @ResponseBody
    ResponseObject viewAll() {
        try {
            List<Staff> staffs = staffServices.getAllStaffs();
            return new ResponseObject(true, Constants.HTTP.SUCCESS, staffs);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject addStaff(@RequestBody Staff staff) {
        try {
            Integer staffId = staffServices.save(staff);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, staff);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);


        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteStaff(@RequestParam("staffId") int staffId) {
        try {
            staffServices.delete(staffId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, staffId);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject findStaff(@RequestParam("staffId") int staffId) {
        try {
            Staff staff = staffServices.findById(staffId);
            return new ResponseObject(true, "", staff);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }


    }

    @RequestMapping(value = "/get-staffs")
    public
    @ResponseBody
    ResponseObject getStaffs(@RequestParam(value = "start", required = false) Integer start) {
        List<Staff> staffs;
        try {
            if (start != null) {
                staffs = staffServices.getStaff(start);

            } else {
                staffs = staffServices.getAllStaffs();
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, staffs);

        } catch (Exception e) {
            e.getStackTrace();
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}
