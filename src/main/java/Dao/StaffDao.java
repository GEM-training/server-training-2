package Dao;

import Models.Staff;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */

public interface StaffDao {
    public List<Staff> getStaffs();


    public Integer save(Staff staff);

    public void delete(Integer id);

    public Staff findById(Integer id);
}
