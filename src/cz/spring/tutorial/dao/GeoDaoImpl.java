/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Geotest;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Radek Soucek
 */
@Service
public class GeoDaoImpl implements GeoDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public GeoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    @Transactional
    public Geotest get(int id) {
        //Geotest geoObject = (Geotest) getHibernateTemplate().load(Geotest.class, id);
        Session session = sessionFactory.openSession();       
        Geotest geoObject = (Geotest) session.load(Geotest.class, id);        
        return geoObject;        
    }

    @Override
    public int create(Geotest t) {
        return (int) sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void update(Geotest t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(Geotest t) {        
        if (null != t) {
            this.sessionFactory.getCurrentSession().delete(t);
        }
    }

    @Override
    public List<Geotest> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Geotest").list();
    }

    @Override
    public List<Geotest> list(Criteria crit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
