/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import cz.spring.tutorial.dao.PlayerDao;
import cz.spring.tutorial.model.Player;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Radek Soucek
 */
@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerDao playerDao;
    
    @Override
    public Player get(int id) {
        return playerDao.get(id);
    }

    @Override
    public int create(Player t) {
        return playerDao.create(t);
    }

    @Override
    public void update(Player t) {
        playerDao.update(t);
    }

    @Override
    public void delete(Player t) {
        playerDao.delete(t);
    }

    @Override
    public List<Player> getAll() {
        return playerDao.getAll();
    }

    @Override
    public List<Player> list(Criteria crit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Player> getPlayersByType(String type) {
        return playerDao.getPlayersByType(type);
    }

    @Override
    public List<Player> getPlayersWithMostLogs() {
        return playerDao.getPlayersWithMostLogs();
    }

    @Override
    public List<Player> getPlayersByName(String name) {
        return playerDao.getPlayersByName(name);
    }
    
    
    
}
