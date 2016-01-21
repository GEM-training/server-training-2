package Dao;

import Models.Dealer;
import Models.Make;
import Models.Staff;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public interface StaffsDao {
    public List<Staff> getAllStaffs();
    public Integer save(Staff staff);
    public void deleteStaff(Integer id);
    public Staff findById(Integer id);
}
