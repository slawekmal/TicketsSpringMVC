/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Event;
import java.util.List;

/**
 *
 * @author SKM
 */
public interface EventDAO {
        public void addEvent(Event e);
	public void updateEvent(Event e);
	public List<Event> listEvents();
	public Event getEventById(int id);
	public void removeEvent(int id);
}
