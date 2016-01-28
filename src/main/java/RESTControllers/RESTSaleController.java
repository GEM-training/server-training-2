package RESTControllers;

import Models.ResponseObject;
import Models.Sale;
import Services.SaleServices;
import Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jojo on 21/01/2016.
 */

@RestController
@RequestMapping("/api/sale")

public class RESTSaleController {
    @Autowired
    SaleServices saleServices;

    @RequestMapping(value = "/get-sales", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getSales(@RequestParam(value = "start", required = false) Integer start) {
        List<Sale> sales;
        try {
            if(start == null) {
                sales = saleServices.getAllSales();
            }
            else{
                sales = saleServices.getSales(start);
            }
            return new ResponseObject(true, Constants.HTTP.SUCCESS, sales);
        }
        catch (Exception e){
            e.getStackTrace();
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody Sale sale) {
        try {
            Integer saleId = saleServices.save(sale);
            return new ResponseObject(true, "", saleId);
        }
        catch(Exception e)
        {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("saleId") Integer saleId) {
        try{
            saleServices.delete(saleId);
            return new ResponseObject(true, "", null);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/find")
    public
    @ResponseBody
    ResponseObject find(@RequestParam("saleId") Integer saleId) {
        try{
            Sale sale = saleServices.findById(saleId);
            return new ResponseObject(true, "", sale);
        }
        catch (Exception e){
            return new ResponseObject(false, e.getMessage(), null);
        }
    }
}


