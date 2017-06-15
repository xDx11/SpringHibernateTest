/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import cz.spring.tutorial.dao.GeoDao;
import cz.spring.tutorial.model.Geotest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Radek Soucek
 */
@Service
public class GeoServiceImpl implements GeoService{
    
    @Autowired
    private GeoDao geoDao; 

    @Override
    public void addGeoObject(Geotest object) {
        geoDao.create(object);
    }

    @Override
    public void updateGeotestObject(Geotest object) {
        geoDao.update(object);
    }

    @Override
    @Transactional
    public Geotest getGeoObject(int id) {
        return geoDao.get(id);
    }

    @Override
    public void deleteGeoObject(int id) {
        geoDao.delete(geoDao.get(id));
    }

    @Override
    public List<Geotest> getGeoList() {
        return geoDao.getAll();
    }
    
}
