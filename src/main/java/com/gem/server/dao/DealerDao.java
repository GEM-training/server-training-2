package com.gem.server.dao;

import com.gem.server.model.Dealer;
import com.gem.server.model.Inventory;
import com.gem.server.model.Product;
import com.gem.server.model.Sale;

import java.util.List;

/**
 * Created by phong on 20/01/2016.
 */
public interface DealerDao extends GenericDao<Dealer> {
    List<Dealer> getDealer(int startIndex);

    List<Product> getProducts(Integer dealerId);

    List<Inventory> getInventories(Integer dealerId);

    List<Sale> getSales(Integer dealerId);
}
