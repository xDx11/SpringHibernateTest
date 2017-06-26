/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.controller;

import cz.spring.tutorial.model.Geocache;
import cz.spring.tutorial.service.GeocacheService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Prdík
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/geocache/")
public class RestController {
    
    @Autowired
    private GeocacheService geocacheService;
    
    @RequestMapping(value = "/geocache", method = RequestMethod.GET)
    public ResponseEntity<List<Geocache>> getGeocachesList(){
        List<Geocache> list = geocacheService.getGeoList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/geocache/{id}", method = RequestMethod.GET)
    public ResponseEntity<Geocache> getGeocache(@PathVariable("id") int id){
        Geocache geocache = geocacheService.getGeoObject(id);
        return new ResponseEntity<>(geocache, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/geocache", method = RequestMethod.POST)
    public ResponseEntity<?> addGeocache(Geocache cache){
        int id = geocacheService.addGeoObject(cache);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/geocache/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Geocache> deleteGeocache(@PathVariable("id") int id){
        geocacheService.deleteGeoObject(geocacheService.getGeoObject(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/geocache", method = RequestMethod.PUT)
    public ResponseEntity<Geocache> updateGeocache(Geocache cache){
        geocacheService.updateGeotestObject(cache);
        return new ResponseEntity<>(cache, HttpStatus.OK);
    }
    
}
