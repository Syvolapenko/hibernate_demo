package com.goit11.configuration;

import com.goit11.Entity.Client.Client;
import com.goit11.Entity.Planet.Planet;
import com.goit11.Entity.Ticket.Ticket;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateConfigurations {
    @Getter
    private SessionFactory sessionFactory;
    private static final HibernateConfigurations INSTANCE;

    static {
        INSTANCE = new HibernateConfigurations();
    }
    private HibernateConfigurations(){
         sessionFactory = new Configuration()
                 .addAnnotatedClass(Planet.class)
                 .addAnnotatedClass(Client.class)
                 .addAnnotatedClass(Ticket.class)
                 .buildSessionFactory();
    }
    public static HibernateConfigurations getInstance(){
        return INSTANCE;
    }
    public void close(){
        sessionFactory.close();
    }

    public static void main(String[] args) {
        Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession();
        List<Planet> clientList = session.createQuery("from Planet", Planet.class).list();
        System.out.println("clientList = " + clientList);
        session.close();
    }
}
