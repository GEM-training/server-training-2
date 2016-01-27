package Dao.Impls;

import Dao.AbstractDao;
import Dao.SaleDao;
import Models.Sale;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
@Transactional
public class SaleDaoImpl extends AbstractDao implements SaleDao {
    public List<Sale> getAllSales() {
        Criteria crt = getSession().createCriteria(Sale.class);
        return (List<Sale>) crt.list();
    }

    public Integer save(Sale sale) {
        return (Integer) getSession().save(sale);
    }

    public void delete(Integer saleId) {
        Sale sale = getSession().load(Sale.class, saleId);
        if (sale != null) {
            getSession().delete(sale);
        }
    }


    public Sale findById(Integer saleId) {
        return getSession().get(Sale.class, saleId);
    }

}
