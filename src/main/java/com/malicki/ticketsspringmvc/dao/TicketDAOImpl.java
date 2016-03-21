package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDAOImpl implements TicketDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(TicketDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public void addTicket(Ticket t) {
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Ticket saved successfully, Ticket Details=" + t);
    }

    @Override
    public void updateTicket(Ticket t) {
        Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Ticket updated successfully, Ticket Details=" + t);
    }

    @Override
    public List<Ticket> listTickets() {
        Session session = this.sessionFactory.getCurrentSession();
		List<Ticket> TicketList = session.createQuery("from Ticket").list();
		for(Ticket t : TicketList){
			logger.info("Ticket List::" + t);
		}
		return TicketList;
    }

    @Override
    public Ticket getTicketById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
		Ticket t = (Ticket) session.load(Ticket.class, new Integer(id));
		logger.info("Ticket loaded successfully, Ticket details=" + t);
		return t;
    }

    @Override
    public void removeTicket(int id) {
        Session session = this.sessionFactory.getCurrentSession();
		Ticket t = (Ticket) session.load(Ticket.class, new Integer(id));
		if(null != t){
			session.delete(t);
		}
		logger.info("Ticket deleted successfully, Ticket details=" + t);
    }

}
