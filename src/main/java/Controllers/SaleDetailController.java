package Controllers;

import Dao.SaleDetailDao;
import Models.ResponseObject;
import Models.Sale;
import Models.SaleDetail;
import Services.SaleDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/saleDetail")
@Transactional

public class SaleDetailController {
    @Autowired
    SaleDetailServices saleDetailServices;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getListSaleDetail() {
        try{
            List<SaleDetail> saleDetails= saleDetailServices.getAllSaleDetails();
            return new ResponseObject(true, "", saleDetails);
        }
        catch (Exception e)
        {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add-one")
    public
    @ResponseBody
    ResponseObject addOneSaleDetail(@RequestBody SaleDetail saleDetail) {
        try{
            saleDetailServices.save(saleDetail);
            return new ResponseObject(true, "", saleDetail);
        }
        catch (Exception e)
        {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("saleDetailId") Integer saleDetailId) {
        try{
            saleDetailServices.delete(saleDetailId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/find-one")
    public
    @ResponseBody
    ResponseObject findSaleDetail(@RequestParam Integer saleDetailId) {
        try{
            SaleDetail saleDetail = saleDetailServices.findById(saleDetailId);
            return new ResponseObject(true, "", saleDetail);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}
