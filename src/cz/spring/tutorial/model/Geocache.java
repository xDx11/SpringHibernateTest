/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.model;

import java.io.Serializable;
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
@Table(name="geocache")
public class Geocache implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="geocache_id", nullable=false)
    private int id;
    @Column(name="geocache_title", nullable=false)
    private String name;
    @Column(name="geocache_code", nullable=true)
    private String code;
    @Column(name="geocache_help", nullable=true)
    private String help;
    @Column(name="geocache_desc", nullable=true)
    private String desc;
    @Column(name="geocache_size", nullable=true)
    private double size;
    @Column(name="geocache_diff", nullable=true)
    private double diff;
    
    @OneToMany(mappedBy = "geocache", cascade = CascadeType.ALL)
    private List<Cachelog> logs;

    public Geocache() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public List<Cachelog> getLogs() {
        return logs;
    }

    public void setLogs(List<Cachelog> logs) {
        this.logs = logs;
    }
    
    
    
    
}
