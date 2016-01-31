package com.gem.server.dao;

import com.gem.server.model.Make;
import com.gem.server.model.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by hoapham on 19/01/2016.
 */
public interface MakeDao extends GenericDao<Make> {

    List<Make> getMakes(int startIndex);

    Set<Product> getProducts(Integer makeId);

}
