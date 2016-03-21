/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Ticket;
import java.util.List;

/**
 *
 * @author SKM
 */
public interface TicketDAO {
     public void addTicket(Ticket t);
	public void updateTicket(Ticket t);
	public List<Ticket> listTickets();
	public Ticket getTicketById(int id);
	public void removeTicket(int id);
}
