package Dao.Impls;

import Dao.AbstractDao;
import Dao.SaleDetailDao;
import Models.SaleDetail;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
@Transactional
public class SaleDetailDaoImpl extends AbstractDao implements SaleDetailDao {
    public List<SaleDetail> getAllSaleDetails() {
        Criteria criteria = getSession().createCriteria(SaleDetail.class);
        return (List<SaleDetail>) criteria.list();
    }

    public Integer save(SaleDetail saleDetail) {
        return (Integer) getSession().save(saleDetail);
    }

    public void delete(Integer saleDetailId) {
        SaleDetail SaleDetail = getSession().load(SaleDetail.class, saleDetailId);
        if (SaleDetail != null) {
            getSession().delete(SaleDetail);
        }
    }

    public SaleDetail findById(Integer saleDetailId) {
        return getSession().get(SaleDetail.class, saleDetailId);
    }
}
