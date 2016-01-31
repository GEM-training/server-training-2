package com.gem.server.service.impl;

import com.gem.server.dao.StaffDao;
import com.gem.server.model.Staff;
import com.gem.server.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDao staffDao;

    public List<Staff> getAllStaffs() {
        return staffDao.findAll();
    }

    public Integer save(Staff staff) {
        return staffDao.save(staff);
    }

    public boolean delete(Integer staffId) {
        try {
            staffDao.deleteById(staffId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Staff findById(Integer staffId) {
        return staffDao.findById(staffId);
    }

    public List<Staff> getStaff(int startIndex) {
        return staffDao.getStaffs(startIndex);
    }
}
