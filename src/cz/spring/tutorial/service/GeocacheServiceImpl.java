/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import cz.spring.tutorial.dao.GeocacheDao;
import cz.spring.tutorial.model.Geocache;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Radek Soucek
 */
@Service
public class GeocacheServiceImpl implements GeocacheService{
    
    @Autowired
    private GeocacheDao geocacheDao; 

    @Override
    public int addGeoObject(Geocache object) {
        return geocacheDao.create(object);
    }

    @Override
    public void updateGeotestObject(Geocache object) {
        geocacheDao.update(object);
    }

    @Override
    public Geocache getGeoObject(int id) {
        return geocacheDao.get(id);
    }

    @Override
    public void deleteGeoObject(Geocache item) {        
        geocacheDao.delete(item);
    }

    @Override
    public List<Geocache> getGeoList() {
        return geocacheDao.getAll();
    }
    
}
