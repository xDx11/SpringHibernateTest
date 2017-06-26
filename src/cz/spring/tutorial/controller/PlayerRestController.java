/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.controller;

import cz.spring.tutorial.model.Geocache;
import cz.spring.tutorial.model.Player;
import cz.spring.tutorial.service.PlayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Prdík
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/players/")
public class PlayerRestController {
    
    @Autowired
    private PlayerService playerService;
    
    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayerList(){
        List<Player> list = playerService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") int id){
        Player player = playerService.get(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/player", method = RequestMethod.POST)
    public ResponseEntity<?> addPlayer(Player player){
        int id = playerService.create(player);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/player/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Player> deletePlayer(@PathVariable("id") int id){
        playerService.delete(playerService.get(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/player", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayer(Player player){
        playerService.update(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
