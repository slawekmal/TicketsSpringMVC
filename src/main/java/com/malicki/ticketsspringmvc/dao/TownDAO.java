/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Town;
import java.util.List;

/**
 *
 * @author SKM
 */
public interface TownDAO {
    
    public void addTown(Town t);

    public void updateTown(Town t);

    public List<Town> listTowns();

    public Town getTownById(int id);

    public void removeTown(int id);
}
