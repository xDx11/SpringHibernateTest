/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Geocache;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Radek Soucek
 */
@Service
public class GeocacheDaoImpl implements GeocacheDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    public GeocacheDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }

    @Override
    public Geocache get(int id) {
        //Session session = sessionFactory.openSession();       
        Geocache geocache = (Geocache) session.load(Geocache.class, id);        
        return geocache;     
    }

    @Override
    public void create(Geocache t) {
        Session session = sessionFactory.openSession();       
        session.save(t);
    }

    @Override
    public void update(Geocache t) {
        Session session = sessionFactory.openSession();       
        session.update(t);
    }

    @Override
    public void delete(Geocache t) {
        Session session = sessionFactory.openSession();       
        session.delete(t);
    }

    @Override
    public List<Geocache> getAll() {
        //Session session = sessionFactory.openSession();       
        return (List<Geocache>) session.createQuery("from Geocache").list();
    }

    @Override
    public List<Geocache> list(Criteria crit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
