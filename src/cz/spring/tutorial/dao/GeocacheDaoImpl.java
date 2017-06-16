/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Cachelog;
import cz.spring.tutorial.model.Geocache;
import cz.spring.tutorial.util.SizeOrder;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Radek Soucek
 */
@Component
public class GeocacheDaoImpl implements GeocacheDao{
        
    private SessionFactory mySessionFactory;
    private Session session;       
        
    public GeocacheDaoImpl(){
        
    }
    
    public GeocacheDaoImpl(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }  

    @Override
    public Geocache get(int id) {
        //Session session = mySessionFactory.openSession();       
        //Geocache geocache = (Geocache) session.load(Geocache.class, id);        
        Geocache geocache = (Geocache) session.get(Geocache.class, id);        
        return geocache;     
    }

    @Override
    public int create(Geocache t) {
        int i = (int) session.save(t);        
        return i;
        /*
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            int i = (int) session.save(t);
            tx.commit();
            return i;
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            throw e;
        }
        */             
    }

    @Override
    public void update(Geocache t) {
        //Session session2 = mySessionFactory.getCurrentSession();
        session.update(t);
    }

    @Override
    public void delete(Geocache t) {
        //Session session2 = mySessionFactory.getCurrentSession();
        session.delete(t);
    }

    @Override
    public List<Geocache> getAll() {
        //Session session = mySessionFactory.openSession();       
        return (List<Geocache>) session.createQuery("from Geocache").list();
    }

    @Override
    public List<Geocache> list(Criteria crit) {
        return (List<Geocache>) crit.list();
    }

    @Override
    public List<Geocache> getCachesByType(String type) {
        Criteria crit = session.createCriteria(Geocache.class);
        switch(type.toLowerCase()){
            case "mystery":
                crit.add(Restrictions.like("type", "%mystery%"));
                break;
            case "multi":
                crit.add(Restrictions.like("type", "%multi%"));
                break;
            case "earth":
                crit.add(Restrictions.like("type", "%earth%"));
                break;
            default:
                crit.add(Restrictions.like("type", "%tradition%"));
                break;
        }
        return (List<Geocache>) crit.list();
    }

    @Override
    public List<Geocache> getCachesBySize(Double size, String typeEqualGreatLess) {
        Criteria crit = session.createCriteria(Geocache.class);
        switch(typeEqualGreatLess.toLowerCase()){
            case "equal":
                crit.add(Restrictions.eq("size", size));
                break;
            case "greater":
                crit.add(Restrictions.gt("size", size));
                break;
            case "less":
                crit.add(Restrictions.lt("size", size));
                break;
            default:
                crit.add(Restrictions.eq("size", size));
                break;
        }
        return (List<Geocache>) crit.list();
    }

    @Override
    public List<Geocache> getCachesWithMostLogs() {
        Criteria critGeocache = session.createCriteria(Geocache.class);
        critGeocache.addOrder(SizeOrder.desc("logs"));
        critGeocache.setMaxResults(10);
        
        return (List<Geocache>) critGeocache.list();
        //Criteria critCachelog = session.createCriteria(Cachelog.class);
        
    }

    @Override
    public List<Geocache> getCachesByName(String name) {
        Criteria crit = session.createCriteria(Geocache.class);
        crit.add(Restrictions.like("name", "%"+name+"%"));
        return (List<Geocache>) crit.list();
    }

    @Override
    public double getAvfCachesDiff() {
        Criteria crit = session.createCriteria(Geocache.class);
        crit.setProjection(Projections.avg("diff"));
        List result = crit.list();
        return (double) result.get(0);
    }
    
    
    
}
