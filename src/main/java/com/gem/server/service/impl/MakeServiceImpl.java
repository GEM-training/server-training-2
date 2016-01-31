package com.gem.server.service.impl;

import com.gem.server.dao.MakeDao;
import com.gem.server.model.Make;
import com.gem.server.model.Product;
import com.gem.server.model.ResponseObject;
import com.gem.server.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by hoak57uet on 1/21/16.
 */
@Transactional
public class MakeServiceImpl implements MakeService {
    @Autowired
    MakeDao makeDao;

    public ResponseObject findById(Integer id) {
        try {
            return new ResponseObject(true, "", makeDao.findById(id));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject findAll() {
        try {
            return new ResponseObject(true, "", makeDao.findAll());
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject save(Make make) {
        try {
            return new ResponseObject(true, "", makeDao.save(make));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject update(Make make) {
        Make old = makeDao.findById(make.getMakeId());
        try {
            makeDao.update(make);
            return new ResponseObject(true, "", make);
        } catch (Exception e) {
            return new ResponseObject(false, "", old);
        }
    }

    public ResponseObject delete(Make make) {
        try {
            makeDao.delete(make);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject deleteById(Integer makeId) {
        try {
            makeDao.deleteById(makeId);
            return new ResponseObject(true, "", null);
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getMakes(int start) {
        try {
            return new ResponseObject(true, "", makeDao.getMakes(start));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }

    public ResponseObject getProducts(Integer makeId) {
        try {
            return new ResponseObject(true, "", makeDao.getProducts(makeId));
        } catch (Exception e) {
            return new ResponseObject(false, "", null);
        }
    }
}
