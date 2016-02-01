package com.gem.server.service;

import com.gem.server.model.ResponseObject;
import com.gem.server.model.Staff;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface StaffService {
    ResponseObject getStaffs(int staffIndex);

    ResponseObject save(Staff staff);

    ResponseObject deleteById(Integer staffId);

    ResponseObject findById(Integer staffId);

    ResponseObject findAlls();

    ResponseObject update(Staff staff);


}
