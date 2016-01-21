package Dao;

import Models.Dealer;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public interface DealersDao {
    public List<Dealer> getAllDealers();
    public Integer save(Dealer dealer);
    public void delete(Integer id);
    public Dealer findById(Integer id);
}
