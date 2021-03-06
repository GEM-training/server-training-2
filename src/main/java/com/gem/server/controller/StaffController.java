package com.gem.server.controller;

import com.gem.server.model.Dealer;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.Staff;
import com.gem.server.service.StaffService;
import com.gem.server.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/api/staff")

public class StaffController {
    @Autowired
    StaffService staffService;




    @RequestMapping(value = "/save")
    public
    @ResponseBody
    ResponseObject save(@RequestBody Staff staff) {
        return staffService.save(staff);
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("staffId") int staffId) {
        return staffService.deleteById(staffId);

    }

    @RequestMapping(value = "/update")
    public
    @ResponseBody
    ResponseObject update(@RequestBody @Valid Staff staff, BindingResult error) throws Exception {

        if (error.hasErrors())
            return new ResponseObject(false, error.getAllErrors().get(0).getDefaultMessage(), null);
        return staffService.update(staff);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject find(@RequestParam("staffId") int staffId) {
       return staffService.findById(staffId);


    }

    @RequestMapping(value = "/get")
    public
    @ResponseBody
    ResponseObject get(@RequestParam(value = "start", required = false) Integer start) {
        if(start!=null) {
            return  staffService.getStaffs(start);
        }else {
            return staffService.findAlls();
        }
        }
}
