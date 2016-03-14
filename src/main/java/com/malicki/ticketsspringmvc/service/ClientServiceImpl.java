package com.malicki.ticketsspringmvc.service;

import com.malicki.ticketsspringmvc.dao.ClientDAO;
import com.malicki.ticketsspringmvc.model.Client;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDAO ClientDAO;

    public void setClientDAO(ClientDAO ClientDAO) {
        this.ClientDAO = ClientDAO;
    }

    @Override
    @Transactional
    public void addClient(Client c) {
        this.ClientDAO.addClient(c);
    }

    @Override
    @Transactional
    public void updateClient(Client c) {
        this.ClientDAO.updateClient(c);
    }

    @Override
    @Transactional
    public List<Client> listClients() {
        return this.ClientDAO.listClients();
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return this.ClientDAO.getClientById(id);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.ClientDAO.removeClient(id);
    }

    @Override
    @Transactional
    public boolean isValidUser(String email, String password) throws SQLException {
        return ClientDAO.isValidUser(email, password);
    }

}
