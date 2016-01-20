package Dao;

import Models.SaleDetail;
import Models.Sale;
import Models.SaleDetail;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by jojo on 20/01/2016.
 */
public class SaleDetailDaoImpl extends AbstractDao implements SaleDetailDao{
    public List<SaleDetail> getAllSaleDetails(){
        Criteria criteria = getSession().createCriteria(SaleDetail.class);
        return (List<SaleDetail>)criteria.list();
    }

    public Integer save(SaleDetail SaleDetail){
        return (Integer)getSession().save(SaleDetail);
    }

    public void deleteSaleDetail(Integer SaleDetailId){
        SaleDetail SaleDetail = getSession().load(SaleDetail.class, SaleDetailId);
        if(SaleDetail != null)
        {
            getSession().delete(SaleDetail);
        }
    }

    public SaleDetail findById(Integer SaleDetailId){
        return (SaleDetail)getObjectById(SaleDetailId);
    }


}
