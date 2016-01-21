package Dao;

import Models.Staff;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */

public interface StaffDao {
    List<Staff> getAllStaffs();


    Integer save(Staff staff);

    void delete(Integer id);

    Staff findById(Integer id);
}
