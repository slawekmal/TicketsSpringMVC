package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Town;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TownDAOImpl implements TownDAO{
    private static final Logger logger = LoggerFactory.getLogger(TownDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public void addTown(Town t) {
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Town saved successfully, Town Details=" + t);
    }

    @Override
    public void updateTown(Town t) {
        Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Town updated successfully, Town Details=" + t);
    }

    @Override
    public List<Town> listTowns() {
        Session session = this.sessionFactory.getCurrentSession();
		List<Town> TownList = session.createQuery("from Town").list();
		for(Town t : TownList){
			logger.info("Town List::" + t);
		}
		return TownList;
    }

    @Override
    public Town getTownById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
		Town t = (Town) session.load(Town.class, new Integer(id));
		logger.info("Town loaded successfully, Town details=" + t);
		return t;
    }

    @Override
    public void removeTown(int id) {
        Session session = this.sessionFactory.getCurrentSession();
		Town t = (Town) session.load(Town.class, new Integer(id));
		if(null != t){
			session.delete(t);
		}
		logger.info("Town deleted successfully, Town details=" + t);
    }

}
