package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.dao.TicketDAO;
import com.malicki.ticketsspringmvc.model.Ticket;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService{
    
    private TicketDAO TicketDAO;
    
    public void setTicketDAO(TicketDAO TicketDAO){
        this.TicketDAO = TicketDAO;
    }

    @Override
    @Transactional
    public void addTicket(Ticket t) {
        this.TicketDAO.addTicket(t);
    }

    @Override
    @Transactional
    public void updateTicket(Ticket t) {
        this.TicketDAO.updateTicket(t);
    }

    @Override
    @Transactional
    public List<Ticket> listTickets() {
        return this.TicketDAO.listTickets();
    }

    @Override
    @Transactional
    public Ticket getTicketById(int id) {
        return this.TicketDAO.getTicketById(id);
    }

    @Override
    @Transactional
    public void removeTicket(int id) {
        this.TicketDAO.removeTicket(id);
    }

}
