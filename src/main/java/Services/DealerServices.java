package Services;

import Models.Dealer;
import Models.Staff;

import java.util.List;

/**
 * Created by phong on 1/22/2016.
 */
public interface DealerServices {
    List<Dealer> getAllDealers();

    Integer save(Dealer dealer);

    void delete(Integer dealerId);

    Dealer findById(Integer dealerId);
}
