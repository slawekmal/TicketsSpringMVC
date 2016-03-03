package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.dao.TownDAO;
import com.malicki.ticketsspringmvc.model.Town;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TownServiceImpl implements TownService{
    
    private TownDAO TownDAO;
    
    public void setTownDAO(TownDAO TownDAO){
        this.TownDAO = TownDAO;
    }

    @Override
    @Transactional
    public void addTown(Town t) {
        this.TownDAO.addTown(t);
    }

    @Override
    @Transactional
    public void updateTown(Town t) {
        this.TownDAO.updateTown(t);
    }

    @Override
    @Transactional
    public List<Town> listTowns() {
        return this.TownDAO.listTowns();
    }

    @Override
    @Transactional
    public Town getTownById(int id) {
        return this.TownDAO.getTownById(id);
    }

    @Override
    @Transactional
    public void removeTown(int id) {
        this.TownDAO.removeTown(id);
    }

}
