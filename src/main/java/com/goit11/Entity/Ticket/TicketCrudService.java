package com.goit11.Entity.Ticket;
import com.goit11.Entity.Client.Client;
import com.goit11.Entity.Planet.Planet;
import com.goit11.configuration.HibernateConfigurations;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class TicketCrudService implements TicketDaoService{
    @Override
    public List<Ticket> listTickets() {
        List<Ticket> tickets;
        try(Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            tickets = session.createQuery("from Ticket", Ticket.class).list();
        }
        return tickets;
    }

    @Override
    public void createTicket(Ticket ticket, long clientId, String timestamp, String idPlanetFrom,String idPlanetTo) throws SQLException, ParseException {
        try (Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(timestamp);
            ticket.setCreatedAt(date);
            Client client = session.get(Client.class,clientId);
            if(client == null){
                session.close();
            }
            Planet planetFrom = session.get(Planet.class,idPlanetFrom);
            Planet planetTo = session.get(Planet.class,idPlanetTo);
            if(planetFrom==null||planetTo==null){
                session.close();
            }
            ticket.setClient(client);
            ticket.setFromPlanet(planetFrom);
            ticket.setToPlanet(planetTo);
            session.persist(ticket);
            session.close();
            System.out.println("New ticket created");
        }
    }

    @Override
    public Ticket getByIdTicket(Long id) throws SQLException {
        Ticket ticket = new Ticket();
        try (Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            ticket = session.get(Ticket.class,id);
            session.close();
        }
        return ticket;
    }
    @Override
    public void updateTicket(Long idTicket,String timestamp,Long clientId) throws SQLException, ParseException {
        try (Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket updateTicket = session.get(Ticket.class, idTicket);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(timestamp);
            updateTicket.setCreatedAt(date);
            Client client = session.get(Client.class, clientId);
            if (client == null) {
                session.close();
            }
            updateTicket.setClient(client);
            transaction.commit();
            session.close();
            System.out.println("Ticket update");
        }
    }
    @Override
    public void removeTicket(Long id) throws SQLException {
        try (Session session = HibernateConfigurations.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class,id);
            session.remove(ticket);
            transaction.commit();
            session.close();
            System.out.println("Ticket deleted");
        }
    }
}
