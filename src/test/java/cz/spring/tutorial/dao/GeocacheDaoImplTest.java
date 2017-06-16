/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.cz.spring.tutorial.dao;

import cz.spring.tutorial.dao.GeocacheDao;
import cz.spring.tutorial.dao.GeocacheDaoImpl;
import cz.spring.tutorial.model.Geocache;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/application-context.xml")
@Transactional
public class GeocacheDaoImplTest {
    
    private GeocacheDao geocacheDao;

    @Autowired
    public void setGeocacheDao(GeocacheDao geocacheDao) {
        this.geocacheDao = geocacheDao;
    }
    
    
    
    public GeocacheDaoImplTest() {
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
     * Test of setSessionFactory method, of class GeocacheDaoImpl.
     */
    @Test
    public void testSetSessionFactory() {
        assertNotNull(geocacheDao);
    }

    /**
     * Test of get method, of class GeocacheDaoImpl.
     */
    @Test
    public void testGet() {
        System.out.println("getGeoObject");
        int id = 0;
        Geocache cache = geocacheDao.get(1);
        assertNotNull(cache);
        System.out.println("id is: " + cache.getId());
        System.out.println("Name is: " + cache.getName());
        assertEquals(1, cache.getId());
        assertEquals("Cache 1", cache.getName());
    }
    
    /**
     * Test of create method, of class GeocacheDaoImpl.
     */
    @Test    
    public void testCreate() {
        System.out.println("createGeocache");        
        int id = 0;
        Geocache geocache = new Geocache();
        geocache.setName("GeoDAO_TestName");        
        id = geocacheDao.create(geocache);
        System.out.println("Create id id: " + id);
        geocache.setId(id);
        assertNotEquals(0, id);               
        if(id<0){
            fail("Save exception, id < 0");
        }   
    }
    
    /**
     * Test of update method, of class GeocacheDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int id = 0;
        Geocache geocache = new Geocache();
        geocache.setName("GeoDAO_TestCREATE");        
        id = geocacheDao.create(geocache);
        System.out.println("Create id id: " + id);
        geocache.setId(id);
        String updateName = "UPDATED NAME";
        geocache.setName(updateName);
        geocacheDao.update(geocache);
        Geocache updatedGeo = geocacheDao.get(id);
        System.out.println("updated GEO name: " + updatedGeo.getName());
        assertNotNull(updatedGeo);               
        assertEquals(updateName, updatedGeo.getName());
    }
    
    /**
     * Test of delete method, of class GeocacheDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Geocache oldCache = geocacheDao.get(1);
        assertNotNull(oldCache);
        geocacheDao.delete(oldCache);
        Geocache deletedCache = geocacheDao.get(1);
        assertNull(deletedCache);
        
    }

    
    
}
