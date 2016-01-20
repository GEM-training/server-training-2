package Dao;

import Models.Sale;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public class SalesDaoImpl extends AbstractDao implements SalesDao {
    public List<Sale> getAllMakes(){
        Criteria crt = getSession().createCriteria(Sale.class);
        return (List<Sale>)crt;
    }

    public Integer save(Sale sale){
        return (Integer)getSession().save(sale);
    }

    public void deleteSale(Integer saleId){
        Sale sale = getSession().load(Sale.class, saleId);
        if (sale != null)
        {
            getSession().delete(sale);
        }
    }

    public Sale findById(Integer saleId){
        return (Sale)getObjectById(saleId);
    }
}
