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
@Transactional
public class RESTDealerController {
    @Autowired
    DealerServices dealerServices;

    @RequestMapping(value = "/list")
    public
    @ResponseBody
    ResponseObject getAllDeals(){
        try{
            List<Dealer> dealers = dealerServices.getAllDealers();
            return  new ResponseObject(true, Constants.HTTP.SUCCESS,dealers);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);

        }
    }
    @RequestMapping(value = "/add-one")
    public
    @ResponseBody
    ResponseObject addOneDealer(@RequestBody Dealer dealer) {
        try{
            Integer dealerId = dealerServices.save(dealer);
            return new ResponseObject(true, Constants.HTTP.SUCCESS,dealerId);
        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);


        }
    }

    @RequestMapping(value = "/delete")
    public
    @ResponseBody
    ResponseObject deleteDealer(@RequestParam("dealerId") int dealerId ) {
        try {
            dealerServices.delete(dealerId);
            return new ResponseObject(true, Constants.HTTP.SUCCESS, dealerId);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getDealById(@PathVariable("id") int id) {
        try {
            Dealer dealer = dealerServices.findById(id);
            return new ResponseObject(true,"",dealer);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }



    }


    @RequestMapping(value = "/{id}/get-staff", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getStaffByDealerId(@PathVariable("id") int id) {
        try {
            List<Staff> staffs = new ArrayList<Staff>();
            Dealer dealer = dealerServices.findById(id);
            staffs.addAll(dealer.getListStaffs());
            return new ResponseObject(true,"",staffs);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }



    }
    @RequestMapping(value = "/{id}/get-inventory", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getInventoryByDealerId(@PathVariable("id") int id) {
        try {
            List<Inventory> inventories = new ArrayList<Inventory>();
            Dealer dealer = dealerServices.findById(id);
            inventories.addAll(dealer.getSetInventories());
            return new ResponseObject(true,"",inventories);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/{id}/get-product", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getProductByDealerId(@PathVariable("id") int id) {
        try {
            List<Product> products = new ArrayList<Product>();
            Dealer dealer = dealerServices.findById(id);
            products.addAll(dealer.getListProducts());
            return new ResponseObject(true,"",products);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/{id}/get-sale", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseObject getSaleByDealerId(@PathVariable("id") int id) {
        try {
            List<Sale> sales = new ArrayList<Sale>();
            Dealer dealer = dealerServices.findById(id);
            sales.addAll(dealer.getListSales());
            return new ResponseObject(true,"",sales);

        }catch (Exception e){
            return new ResponseObject(false,e.getMessage(),null);
        }

    }



}
