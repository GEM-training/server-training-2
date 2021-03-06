package com.gem.server.utils;

/**
 * Created by hoapham on 26/01/2016.
 */
public class Constants {
    public interface HTTP {
        String SUCCESS = "SUCCESS";
    }

    public interface PRODUCT {
        String order = "product_order_attribute";
        String page_size = "product_page_size";
    }

    public interface MAKE {
        String order = "make_order_attribute";
        String page_size = "make_page_size";
    }

    public interface STAFF {
        String order = "staff_order_attribute";
        String page_size = "staff_page_size";
    }

    public interface DEALER {
        String order = "dealer_order_attribute";
        String page_size = "dealer_page_size";
    }

    public interface INVENTORY {
        String order = "inventory_order_attribute";
        String page_size = "inventory_page_size";
    }

    public interface CUSTOMER {
        String order = "customer_order_attribute";
        String page_size = "customer_page_size";
    }

    public interface SALE {
        String order = "sale_order_attribute";
        String page_size = "sale_page_size";
    }

    public interface SALE_DETAIL {
        String order = "sale_detail_order_attribute";
        String page_size = "sale_detail_page_size";
    }
}
