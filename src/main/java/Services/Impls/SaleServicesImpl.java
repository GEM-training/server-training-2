package Services.Impls;

import Dao.SaleDao;
import Models.Sale;
import Services.SaleDetailServices;
import Services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jojo on 22/01/2016.
 */
public class SaleServicesImpl implements SaleServices {
    @Autowired
    SaleDao saleDao;
    public List<Sale> getAllSales(){
        return saleDao.getAllSales();
    }

    public Integer save(Sale sale){
        return saleDao.save(sale);
    }

    public void delete(Integer saleId){
        saleDao.delete(saleId);
    }

    public Sale findById(Integer saleId){
        return saleDao.findById(saleId);
    }
}