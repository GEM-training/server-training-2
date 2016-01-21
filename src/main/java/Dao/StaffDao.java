package Dao;

import Models.Staff;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
<<<<<<< HEAD:src/main/java/Dao/StaffsDao.java
public interface StaffsDao {
    public List<Staff> getAllStaffs();
=======
public interface StaffDao {
    public List<Staff> getStaffs();

>>>>>>> origin/master:src/main/java/Dao/StaffDao.java
    public Integer save(Staff staff);

    public void delete(Integer id);

    public Staff findById(Integer id);
}
