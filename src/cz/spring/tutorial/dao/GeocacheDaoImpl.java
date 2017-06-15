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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
    public int create(Geocache t) {
        return (int) session.save(t);
    }

    @Override
    public void update(Geocache t) {
        
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
