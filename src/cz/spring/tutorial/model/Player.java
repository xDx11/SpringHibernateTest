/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Radek Soucek
 */
@Entity
@Table(name="player")
public class Player implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="player_id", nullable = false)
    private int id;
    @Column(name="player_name", nullable = false)
    private String nick;
    @Column(name="player_registered", nullable = false)
    private Date registered;
    @Column(name="player_member", nullable = true)
    private String member;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Cachelog> logs;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public List<Cachelog> getLogs() {
        return logs;
    }

    public void setLogs(List<Cachelog> logs) {
        this.logs = logs;
    }
    
    
    
}
