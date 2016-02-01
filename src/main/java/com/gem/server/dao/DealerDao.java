package com.gem.server.dao;

import com.gem.server.model.*;

import java.util.List;
import java.util.Set;

/**
 * Created by phong on 20/01/2016.
 */
public interface DealerDao extends GenericDao<Dealer> {
    List<Dealer> getDealers(int startIndex);

    List<Product> getProducts(int dealerId);

    List<Inventory> getInventories(int dealerId);

    List<Staff> getStaffs(int dealerId);

    List<Sale> getSales(int dealerId);
}

