package com.goit11.Entity.Planet;

import com.goit11.configuration.HibernateConfigurations;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.SQLException;
import java.util.List;

public class PlanetCrudService implements PlanetDaoService{
    @Override
    public List<Planet> listPlanets() {
        List<Planet> planets;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            planets = session.createQuery("from Planet", Planet.class).list();
        }
        return planets;
    }

    @Override
    public void createPlanet(String id,String name) throws SQLException {
       Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();
       boolean b= false;
       b = id.matches("[A-Z]+[0-9]+");
        if(b == true) {
            Planet planet = new Planet();
            planet.setId(id);
            planet.setName(name);
            session.persist(planet);
        }else {
            System.out.println("Invalid id");
        }
            transaction.commit();
        }
    @Override
    public Planet getByIdPlanet(String id) throws SQLException {
        Planet planet;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            planet = session.get(Planet.class, id);
            transaction.commit();
        }
        return planet;
    }

    @Override
    public void updatePlanetByName(String id, String name) throws SQLException {
        Planet planet;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            planet = session.get(Planet.class,id);
            planet.setName(name);
            transaction.commit();
        }
        System.out.println("Planet update");

    }

    @Override
    public void removePlanet(String id) throws SQLException {
        Planet planet;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            planet = session.get(Planet.class,id);
            session.remove(planet);
            transaction.commit();
        }
        System.out.println("Planet delete");
    }

    }
