package com.gem.server.service.impl;

import com.gem.server.dao.StaffDao;
import com.gem.server.model.ResponseObject;
import com.gem.server.model.Staff;
import com.gem.server.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by phong on 1/22/2016.
 */
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDao staffDao;

    public ResponseObject getStaffs(int staffIndex) {
        try {
            return new ResponseObject(true, "", staffDao.getStaffs(staffIndex));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }

    }

    public ResponseObject save(Staff staff) {
        try {
            Integer staffId = staffDao.save(staff);
            return new ResponseObject(true, "", staffId);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject deleteById(Integer staffId) {
        try{
            staffDao.deleteById(staffId);
            return new ResponseObject(true, "", null);
        }catch (Exception e){
            return new ResponseObject(false, "", null);

        }
    }

    public ResponseObject findById(Integer staffId) {
        try{

            return new ResponseObject(true, "", staffDao.findById(staffId));
        }catch (Exception e){
            return new ResponseObject(false, "",null);

        }
    }

    public ResponseObject findAlls() {
        try{
            return new ResponseObject(true, "", staffDao.findAll());
        }catch (Exception e){
            return new ResponseObject(false, "",null);

        }
    }
}
