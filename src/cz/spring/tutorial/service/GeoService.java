/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import cz.spring.tutorial.model.Geotest;
import java.util.List;

/**
 *
 * @author Radek Soucek
 */
public interface GeoService {    

    public void addGeoObject(Geotest object);

    public void updateGeotestObject(Geotest object);

    public Geotest getGeoObject(int id);

    public void deleteGeoObject(int id);

    public List<Geotest> getGeoList();
}
