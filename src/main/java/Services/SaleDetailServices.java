package Services;

import Models.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleDetailServices {
    List<SaleDetail> getAllSaleDetails();

    Integer save(SaleDetail saleDetail);

    void delete(Integer saleDetailId);

    SaleDetail findById(Integer saleDetailId);
}
