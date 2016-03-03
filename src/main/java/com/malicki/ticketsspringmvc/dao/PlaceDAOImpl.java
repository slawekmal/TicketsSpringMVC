package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Place;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceDAOImpl implements PlaceDAO {
    private static final Logger logger = LoggerFactory.getLogger(PlaceDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public void addPlace(Place p) {
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Place saved successfully, Place Details=" + p);
    }

    @Override
    public void updatePlace(Place p) {
        Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Place updated successfully, Place Details=" + p);
    }

    @Override
    public List<Place> listPlaces() {
        Session session = this.sessionFactory.getCurrentSession();
		List<Place> PlaceList = session.createQuery("from Place").list();
		for(Place p : PlaceList){
			logger.info("Place List::" + p);
		}
		return PlaceList;
    }

    @Override
    public Place getPlaceById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
		Place p = (Place) session.load(Place.class, new Integer(id));
		logger.info("Place loaded successfully, Place details=" + p);
		return p;
    }

    @Override
    public void removePlace(int id) {
        Session session = this.sessionFactory.getCurrentSession();
		Place p = (Place) session.load(Place.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Place deleted successfully, Place details=" + p);
    }

}
