package com.gem.server.dao;

import com.gem.server.model.Staff;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */

public interface StaffDao extends GenericDao<Staff> {
    List<Staff> getStaffs(int startIndex);
}
