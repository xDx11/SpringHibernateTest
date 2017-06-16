/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.cz.spring.tutorial.service;

import cz.spring.tutorial.model.Geocache;
import cz.spring.tutorial.service.GeocacheService;
import cz.spring.tutorial.service.GeocacheServiceImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Radek Soucek
 */

//@ContextConfiguration(locations="classpath*:GeocacheServiceImplTest-context.xml")  
//@ContextConfiguration(classes = {AppConfigTest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/application-context.xml")  
public class GeocacheServiceImplTest {
    
    @Autowired
    private GeocacheService geocacheService;
    
    public GeocacheServiceImplTest() {
    }   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dependency injection, of class GeocacheServiceImpl.
     */    
    @Test
    public void testServiceNotNull(){
        assertNotNull(geocacheService);
    }
    
    /**
     * Test of add Geocache object, of class GeocacheServiceImpl.
     */  
    @Test
    @Transactional
    @Rollback(true)
    public void testAddGeoObject() {
        System.out.println("addGeoObject");
        int id = 0;
        Geocache geocache = new Geocache();
        geocache.setName("GeocacheTestName");
        id = geocacheService.addGeoObject(geocache);
        geocache.setId(id);
        assertNotEquals(0, id);               
        if(id<0){
            fail("Save exception, id < 0");
        }        
    }    
    /**
     * Test of getGeoObject method, of class GeocacheServiceImpl.
     */
    @Test
    public void testGetGeoObject() {
        System.out.println("getGeoObject");
        int id = 0;
        Geocache cache = geocacheService.getGeoObject(1);
        assertNotNull(cache);
        System.out.println("id is: " + cache.getId());
        System.out.println("Name is: " + cache.getName());
        assertEquals(1, cache.getId());
        assertEquals("Cache 1", cache.getName());
    }
    
    
    /**
     * Test of updateGeotestObject method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testUpdateGeotestObject() {
        System.out.println("updateGeotestObject");        
        Geocache geocache = geocacheService.getGeoObject(1);
        String updName = "GeocacheTestUPDATED";
        geocache.setName(updName);
        geocacheService.updateGeotestObject(geocache);
        
        Geocache geo = geocacheService.getGeoObject(1);
        assertEquals(updName, geo.getName());
    }    

    /**
     * Test of deleteGeoObject method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testDeleteGeoObject() {
        System.out.println("deleteGeoObject");
        Geocache item = null;
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        instance.deleteGeoObject(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGeoList method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testGetGeoList() {
        System.out.println("getGeoList");
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        List<Geocache> expResult = null;
        List<Geocache> result = instance.getGeoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCachesByType method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testGetCachesByType() {
        System.out.println("getCachesByType");
        String type = "";
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        List<Geocache> expResult = null;
        List<Geocache> result = instance.getCachesByType(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCachesBySize method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testGetCachesBySize() {
        System.out.println("getCachesBySize");
        Double size = null;
        String typeEqualGreatLess = "";
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        List<Geocache> expResult = null;
        List<Geocache> result = instance.getCachesBySize(size, typeEqualGreatLess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCachesWithMostLogs method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testGetCachesWithMostLogs() {
        System.out.println("getCachesWithMostLogs");
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        List<Geocache> expResult = null;
        List<Geocache> result = instance.getCachesWithMostLogs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCachesByName method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testGetCachesByName() {
        System.out.println("getCachesByName");
        String name = "";
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        List<Geocache> expResult = null;
        List<Geocache> result = instance.getCachesByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvfCachesDiff method, of class GeocacheServiceImpl.
     */
    @Ignore
    public void testGetAvfCachesDiff() {
        System.out.println("getAvfCachesDiff");
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        double expResult = 0.0;
        double result = instance.getAvfCachesDiff();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    

}
