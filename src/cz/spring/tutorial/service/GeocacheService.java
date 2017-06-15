/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import cz.spring.tutorial.model.Geocache;
import java.util.List;

/**
 *
 * @author Radek Soucek
 */
public interface GeocacheService {
    
    public int addGeoObject(Geocache object);

    public void updateGeotestObject(Geocache object);

    public Geocache getGeoObject(int id);

    public void deleteGeoObject(Geocache object);

    public List<Geocache> getGeoList();
}
