package Services;

import Models.SaleDetail;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public interface SaleDetailServices {
    List<SaleDetail> getAllSaleDetails();

    List<SaleDetail> getSaleDetails(int startIndex);

    Integer save(SaleDetail saleDetail);

    boolean delete(Integer saleDetailId);

    SaleDetail findById(Integer saleDetailId);
}
