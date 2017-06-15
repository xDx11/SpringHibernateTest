/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Player;
import cz.spring.tutorial.util.SizeOrder;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Radek Soucek
 */
@Service
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;  
    private Session session;
    
    public PlayerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }
    
    @Override
    public Player get(int id) {
        Player player = (Player) session.load(Player.class, id);        
        return player;     
    }

    @Override
    public int create(Player t) {
        return (int) session.save(t);
    }

    @Override
    public void update(Player t) {
        session.update(t);
    }

    @Override
    public void delete(Player t) {
        session.delete(t);
    }

    @Override
    public List<Player> getAll() {
        List<Player> players = (List<Player>) session.createQuery("from Player").list();
        /*
        System.out.println("TEST");
        for(Player item : players){            
            System.out.println(item.getNick());            
        }
        System.out.println("TEST-END");
        */
        return players;
    }

    @Override
    public List<Player> list(Criteria crit) {
        return (List<Player>) crit.list();
    }

    @Override
    public List<Player> getPlayersByType(String type) {
        Criteria crit = session.createCriteria(Player.class);
        switch(type.toLowerCase()){
            case "premium":
                crit.add(Restrictions.like("member", "%premium%"));
                break;
            default:
                crit.add(Restrictions.like("member", "%basic%"));
                break;
        }
        return list(crit);
    }

    @Override
    public List<Player> getPlayersWithMostLogs() {
        Criteria crit = session.createCriteria(Player.class);
        crit.addOrder(SizeOrder.desc("logs"));
        crit.setMaxResults(2);
        return list(crit);
    }

    @Override
    public List<Player> getPlayersByName(String name) {
        Criteria crit = session.createCriteria(Player.class);
        crit.add(Restrictions.like("nick", "%"+name+"%"));
        return list(crit);
    }
    
    
}
