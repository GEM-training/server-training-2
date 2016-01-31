package com.gem.server.dao;

import com.gem.server.model.Dealer;
import com.gem.server.model.Make;
import com.gem.server.model.Product;
import com.gem.server.model.Sale;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 20/01/2016.
 */
public interface ProductDao extends GenericDao<Product> {

    List<Product> getProduct(int startIndex);

    Set<Dealer> getDealers(Integer productId);

    Set<Product> getParts(Integer productId);

    Make getMake(Integer productId);

    Set<Sale> getSales(Integer productId);

}
