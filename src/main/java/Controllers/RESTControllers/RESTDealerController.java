package Controllers.RESTControllers;

import Dao.DealersDao;
import Models.*;
import Services.DealerServices;
import Utils.Constants;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by phong on 21/01/2016.
 */
@RestController
@RequestMapping("/api/dealer")

public class RESTDealerController {
    @Autowired
    DealerServices dealerServices;

    @RequestMapping(value = "/view-all")
    public
    @ResponseBody
    ResponseObject viewAll() {
        try {
            List<Dealer> dealers = dealerServices.getAllDealers();
            return new ResponseObject(true, Constants.HTTP.SUCCESS, dealers);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);

        }
    }

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    ResponseObject add(@RequestBody Dealer dealer) {
        try {
            Integer dealerId = dealerServices.save(dealer);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, dealerId);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);


        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject delete(@RequestParam("dealerId") int dealerId) {
        try {
            dealerServices.delete(dealerId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, dealerId);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject find(@RequestParam("dealerId") int dealerId) {
        try {
            Dealer dealer = dealerServices.findById(dealerId);
            return new ResponseObject(true, "", dealer);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }


    }


    @RequestMapping(value = "/get-staff", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getStaff(@PathVariable("dealerId") int dealerId) {
        try {
            List<Staff> staffs = new ArrayList<Staff>();
            Dealer dealer = dealerServices.findById(dealerId);
            staffs.addAll(dealer.getListStaffs());
            return new ResponseObject(true, "", staffs);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }


    }

    @RequestMapping(value = "/get-inventory", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getInventory(@RequestParam("dealerId") int dealerId) {
        try {
            List<Inventory> inventories = new ArrayList<Inventory>();
            Dealer dealer = dealerServices.findById(dealerId);
            inventories.addAll(dealer.getSetInventories());
            return new ResponseObject(true, "", inventories);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-product", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getProduct(@RequestParam("dealerId") int dealerId) {
        try {
            List<Product> products = new ArrayList<Product>();
            Dealer dealer = dealerServices.findById(dealerId);
            products.addAll(dealer.getListProducts());
            return new ResponseObject(true, "", products);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-sale", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getSale(@RequestParam("dealerId") int dealerId) {
        try {
            List<Sale> sales = new ArrayList<Sale>();
            Dealer dealer = dealerServices.findById(dealerId);
            sales.addAll(dealer.getListSales());
            return new ResponseObject(true, "", sales);

        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }

    }


}
