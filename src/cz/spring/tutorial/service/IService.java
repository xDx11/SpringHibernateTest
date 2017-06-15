/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.spring.tutorial.service;

import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Radek Soucek
 */
public interface IService<T> {
    T get(int id);

    int create(T t);

    void update(T t);

    void delete(T t);

    List<T> getAll();

    List<T> list(Criteria crit);
}
