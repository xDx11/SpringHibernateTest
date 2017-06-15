/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.dao;

import cz.spring.tutorial.model.Player;
import java.util.List;

/**
 *
 * @author Radek Soucek
 */
public interface PlayerDao extends IDAO<Player>{
    public List<Player> getPlayersByType(String type);
    public List<Player> getPlayersWithMostLogs();
    public List<Player> getPlayersByName(String name);
    
}
