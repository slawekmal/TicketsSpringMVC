/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.model.Place;
import java.util.List;

/**
 *
 * @author SKM
 */
public interface PlaceService {
            public void addPlace(Place p);
	public void updatePlace(Place p);
	public List<Place> listPlaces();
	public Place getPlaceById(int id);
	public void removePlace(int id);
}
