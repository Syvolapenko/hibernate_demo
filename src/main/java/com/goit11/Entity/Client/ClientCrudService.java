package com.goit11.Entity.Client;

import com.goit11.configuration.HibernateConfigurations;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ClientCrudService implements ClientDaoService{
    @Override
    public List<Client> listClients() {
        List<Client> clients;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            clients = session.createQuery("from Client", Client.class).list();
        }
        return clients;
    }

    @Override
    public void createClient(Client client) throws SQLException {
       try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
           Transaction transaction = session.beginTransaction();
           session.persist(client);
           transaction.commit();
       }
        System.out.println("client " + client.getName()+ " created");
    }

    @Override
    public Client getByIdClient(Long id) throws SQLException {
        Client client;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        client = session.get(Client.class,id);
        transaction.commit();
        }
        return client;
    }

    @Override
    public void updateClient(long id,String name) throws SQLException {
        Client client;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class,id);
            client.setName(name);
            transaction.commit();
        }
        System.out.println("Client update");
    }

    @Override
    public void removeClient(Long id) throws SQLException {
        Client client;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class,id);
            session.remove(client);
            transaction.commit();
        }
        System.out.println("Client delete");
    }
}
