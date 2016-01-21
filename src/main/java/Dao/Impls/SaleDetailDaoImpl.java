package Dao.Impls;

import Dao.AbstractDao;
import Dao.SaleDetailDao;
import Models.SaleDetail;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public class SaleDetailDaoImpl extends AbstractDao implements SaleDetailDao {
    public List<SaleDetail> getAllSaleDetails() {
        Criteria criteria = getSession().createCriteria(SaleDetail.class);
        return (List<SaleDetail>) criteria.list();
    }

    public Integer save(SaleDetail SaleDetail) {
        return (Integer) getSession().save(SaleDetail);
    }

    public void delete(Integer saleDetailId) {
        SaleDetail SaleDetail = getSession().load(SaleDetail.class, saleDetailId);
        if (SaleDetail != null) {
            getSession().delete(SaleDetail);
        }
    }

    public SaleDetail findById(Integer SaleDetailId) {
        return (SaleDetail) getObjectById(SaleDetailId);
    }


}
