/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import cz.spring.tutorial.dao.CachelogDao;
import cz.spring.tutorial.model.Cachelog;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Radek Soucek
 */
@Service
public class CachelogServiceImpl implements CachelogService{

    @Autowired
    private CachelogDao cachelogDao;
    
    @Override
    public Cachelog get(int id) {
        return cachelogDao.get(id);
    }

    @Override
    public void create(Cachelog t) {
        cachelogDao.create(t);
    }

    @Override
    public void update(Cachelog t) {
        cachelogDao.update(t);
    }

    @Override
    public void delete(Cachelog t) {
        cachelogDao.delete(t);
    }

    @Override
    public List<Cachelog> getAll() {
        return cachelogDao.getAll();
    }

    @Override
    public List<Cachelog> list(Criteria crit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
