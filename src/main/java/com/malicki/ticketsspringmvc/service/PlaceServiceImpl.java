package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.dao.PlaceDAO;
import com.malicki.ticketsspringmvc.model.Place;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaceServiceImpl implements PlaceService{
    
    private PlaceDAO PlaceDAO;
    
    public void setPlaceDAO(PlaceDAO PlaceDAO){
        this.PlaceDAO = PlaceDAO;
    }

    @Override
    @Transactional
    public void addPlace(Place p) {
        this.PlaceDAO.addPlace(p);
    }

    @Override
    @Transactional
    public void updatePlace(Place p) {
        this.PlaceDAO.updatePlace(p);
    }

    @Override
    @Transactional
    public List<Place> listPlaces() {
        return this.PlaceDAO.listPlaces();
    }

    @Override
    @Transactional
    public Place getPlaceById(int id) {
        return this.PlaceDAO.getPlaceById(id);
    }

    @Override
    @Transactional
    public void removePlace(int id) {
        this.PlaceDAO.removePlace(id);
    }

}
