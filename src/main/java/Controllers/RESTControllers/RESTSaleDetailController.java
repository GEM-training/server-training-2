package Controllers.RESTControllers;

import Models.ResponseObject;
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
@RequestMapping("/api/saleDetail")

public class RESTSaleDetailController {
    @Autowired
    SaleDetailServices saleDetailServices;

    @RequestMapping(value = "/view-all", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject viewAll() {
        try{
            List<SaleDetail> saleDetails= saleDetailServices.getAllSaleDetails();
            return new ResponseObject(true, "", saleDetails);
        }
        catch (Exception e)
        {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody SaleDetail saleDetail) {
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

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam Integer saleDetailId) {
        try{
            SaleDetail saleDetail = saleDetailServices.findById(saleDetailId);
            return new ResponseObject(true, "", saleDetail);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}
