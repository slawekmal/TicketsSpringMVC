package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.dao.EventDAO;
import com.malicki.ticketsspringmvc.model.Event;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService{
    
    private EventDAO eventDAO;
    
    public void setEventDAO(EventDAO eventDAO){
        this.eventDAO = eventDAO;
    }

    @Override
    @Transactional
    public void addEvent(Event e) {
        this.eventDAO.addEvent(e);
    }

    @Override
    @Transactional
    public void updateEvent(Event e) {
        this.eventDAO.updateEvent(e);
    }

    @Override
    @Transactional
    public List<Event> listEvents() {
        return this.eventDAO.listEvents();
    }

    @Override
    @Transactional
    public Event getEventById(int id) {
        return this.eventDAO.getEventById(id);
    }

    @Override
    @Transactional
    public void removeEvent(int id) {
        this.eventDAO.removeEvent(id);
    }

}
