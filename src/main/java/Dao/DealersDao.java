package Dao;

import Models.Dealer;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public interface DealersDao {
    List<Dealer> getAllDealers();
    Integer save(Dealer dealer);
    void delete(Integer id);
    Dealer findById(Integer id);
}
