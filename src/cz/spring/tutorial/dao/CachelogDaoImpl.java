/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Cachelog;
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
public class CachelogDaoImpl implements CachelogDao{
    
    @Autowired
    private SessionFactory sessionFactory;  
    private Session session;
    
    public CachelogDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }

    @Override
    public Cachelog get(int id) {
        return (Cachelog) session.get(Cachelog.class, id);
    }

    @Override
    public int create(Cachelog t) {
        return (int) session.save(t);
    }

    @Override
    public void update(Cachelog t) {
        session.update(t);
    }

    @Override
    public void delete(Cachelog t) {
        session.delete(t);
    }

    @Override
    public List<Cachelog> getAll() {
        return (List<Cachelog>) session.createQuery("from Cachelog").list();
    }

    @Override
    public List<Cachelog> list(Criteria crit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
