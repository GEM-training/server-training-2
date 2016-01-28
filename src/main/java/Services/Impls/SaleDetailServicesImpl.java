package Services.Impls;

import Dao.SaleDetailDao;
import Models.SaleDetail;
import Services.SaleDetailServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public class SaleDetailServicesImpl implements SaleDetailServices{
    @Autowired
    SaleDetailDao saleDetailDao;

    public List<SaleDetail> getAllSaleDetails(){
        return saleDetailDao.getAllSaleDetails();
    }

    public List<SaleDetail> getSaleDetails(int startIndex){
        return saleDetailDao.getSaleDetails(startIndex);
    }

    public Integer save(SaleDetail saleDetail){
        return saleDetailDao.save(saleDetail);
    }

    public boolean delete(Integer saleDetailId){
        try{
            saleDetailDao.delete(saleDetailId);
            return true;}
        catch(Exception e)
        {
            return false;
        }
    }

    public SaleDetail findById(Integer saleDetailId){
        return saleDetailDao.findById(saleDetailId);
    }
}
