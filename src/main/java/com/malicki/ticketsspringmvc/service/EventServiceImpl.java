package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.dao.EventDAO;
import com.malicki.ticketsspringmvc.model.Event;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{
    
    private EventDAO eventDAO;
    
    public void setEventDAO(EventDAO eventDAO){
        this.eventDAO = eventDAO;
    }

    @Override
    public void addEvent(Event e) {
        this.eventDAO.addEvent(e);
    }

    @Override
    public void updateEvent(Event e) {
        this.eventDAO.updateEvent(e);
    }

    @Override
    public List<Event> listEvents() {
        return this.eventDAO.listEvents();
    }

    @Override
    public Event getEventById(int id) {
        return this.eventDAO.getEventById(id);
    }

    @Override
    public void removeEvent(int id) {
        this.eventDAO.removeEvent(id);
    }

}
