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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
     * Test of addGeoObject method, of class GeocacheServiceImpl.
     */
    
    @Test
    public void testServiceNotNull(){
        assertNotNull(geocacheService);
    }
    
    @Ignore
    public void testAddGeoObject() {
        System.out.println("addGeoObject");
        Geocache object = null;
        GeocacheServiceImpl instance = new GeocacheServiceImpl();
        int expResult = 0;
        int result = instance.addGeoObject(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals(1, cache.getId());
    }
    
    
    

}
