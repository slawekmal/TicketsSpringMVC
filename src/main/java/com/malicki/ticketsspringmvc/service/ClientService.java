/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.model.Client;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SKM
 */
public interface ClientService {
            public void addClient(Client c);
	public void updateClient(Client c);
	public List<Client> listClients();
	public Client getClientById(int id);
	public void removeClient(int id);
        public boolean isValidUser(String username, String password) throws SQLException;
}
