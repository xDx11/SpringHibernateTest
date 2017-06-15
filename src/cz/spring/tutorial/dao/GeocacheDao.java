/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Geocache;
import java.util.List;

/**
 *
 * @author Radek Soucek
 */
public interface GeocacheDao extends IDAO<Geocache>{
    
    public List<Geocache> getCachesByType(String type);
    public List<Geocache> getCachesBySize(String size, String typeEqualGreatLess);
    public List<Geocache> getCachesWithMostLogs();
    public List<Geocache> getCachesByName(String name);
    public double getAvfCachesDiff();
    
}
