/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Radek Soucek
 */
@Entity
@Table(name="cachelog")
public class Cachelog implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="cachelog_id", nullable=false)
    private int id;
    @Column(name="cachelog_date_created", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    @Column(name="cachelog_date_modified", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date modified;
    @Column(name="cachelog_type", nullable=false)
    private String type;
    @Column(name="cachelog_desc", nullable=false)
    private String desc;
    
    @ManyToOne
    @JoinColumn(name = "cachelog_geocache_id")
    private Geocache geocache;
    
    @ManyToOne
    @JoinColumn(name = "cachelog_player_id")
    private Player player;

    public Cachelog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Geocache getGeocache() {
        return geocache;
    }

    public void setGeocache(Geocache geocache) {
        this.geocache = geocache;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    
    
}
