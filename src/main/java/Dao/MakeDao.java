package Dao;

import Models.Make;

import java.util.List;

/**
 * Created by hoapham on 19/01/2016.
 */
public interface MakeDao {
    List<Make> getAllMakes();

    Integer save(Make make);

    void delete(Integer makeId);

    Make findById(Integer makeId);
}
