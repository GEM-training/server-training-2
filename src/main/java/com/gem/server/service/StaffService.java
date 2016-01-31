package com.gem.server.service;

import com.gem.server.model.Staff;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface StaffService {
    List<Staff> getAllStaffs();

    Integer save(Staff staff);

    boolean delete(Integer staffId);

    Staff findById(Integer staffId);

    List<Staff> getStaff(int startIndex);

}
