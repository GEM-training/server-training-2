package Dao;

import Models.Make;

import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
public interface MakeDao {
    public List<Make> getAllMakes();

    public Integer save(Make make);

    public void delete(Integer makeId);

    public Make findById(Integer makeId);
}
