package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(EventDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public void addEvent(Event e) {
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Event saved successfully, Event Details=" + e);
    }

    @Override
    public void updateEvent(Event e) {
        Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Event updated successfully, Event Details=" + e);
    }

    @Override
    public List<Event> listEvents() {
        Session session = this.sessionFactory.getCurrentSession();
		List<Event> eventList = session.createQuery("from Event").list();
		for(Event e : eventList){
			logger.info("Event List::" + e);
		}
		return eventList;
    }

    @Override
    public Event getEventById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
		Event e = (Event) session.load(Event.class, new Integer(id));
		logger.info("Event loaded successfully, Event details=" + e);
		return e;
    }

    @Override
    public void removeEvent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
		Event e = (Event) session.load(Event.class, new Integer(id));
		if(null != e){
			session.delete(e);
		}
		logger.info("Event deleted successfully, event details=" + e);
    }

}
