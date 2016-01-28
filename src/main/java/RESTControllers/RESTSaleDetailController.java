package RESTControllers;

import Models.ResponseObject;
import Models.SaleDetail;
import Services.SaleDetailServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/get-sale-details", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getSaleDetails(@RequestParam(value = "start", required = false) Integer start) {
        List<SaleDetail> saleDetais;
        try {
            if(start == null) {
                saleDetais = saleDetailServices.getAllSaleDetails();
            }
            else{
                saleDetais = saleDetailServices.getSaleDetails(start);
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, saleDetais);
        }
        catch (Exception e){
            e.getStackTrace();
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
