package com.malicki.ticketsspringmvc.dao;

import com.malicki.ticketsspringmvc.model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAOImpl implements ClientDAO {

    private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addClient(Client c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Client saved successfully, Client Details=" + c);
    }

    @Override
    public void updateClient(Client c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("Client updated successfully, Client Details=" + c);
    }

    @Override
    public List<Client> listClients() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Client> ClientList = session.createQuery("from Client").list();
        for (Client c : ClientList) {
            logger.info("Client List::" + c);
        }
        return ClientList;
    }

    @Override
    public Client getClientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client c = (Client) session.load(Client.class, new Integer(id));
        logger.info("Client loaded successfully, Client details=" + c);
        return c;
    }

    @Override
    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client c = (Client) session.load(Client.class, new Integer(id));
        if (null != c) {
            session.delete(c);
        }
        logger.info("Client deleted successfully, Client details=" + c);
    }

    @Override
    public boolean isValidUser(String email, String password) throws SQLException {
        Session session = this.sessionFactory.getCurrentSession();
        String sql_query = "from Client as c where c.email = ? and c.password = ?";
        Query query = session.createQuery(sql_query);
        query.setParameter(0, email);
        query.setParameter(1, password);
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {
            return true;
        } else {
            return false;
        }
    }

}
