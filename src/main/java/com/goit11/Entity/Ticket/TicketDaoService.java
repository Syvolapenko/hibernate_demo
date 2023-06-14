package com.goit11.Entity.Ticket;

import com.goit11.Entity.Client.Client;
import com.goit11.Entity.Planet.Planet;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface TicketDaoService {
    List<Ticket> listTickets();
    void createTicket(Ticket ticket,long clientId,String timestamp,String idFrom, String idTo) throws SQLException, ParseException;
    Ticket getByIdTicket(Long id) throws SQLException;
    void updateTicket(Long idTicket,String timestamp,Long clientId) throws  SQLException, ParseException;
    void removeTicket(Long id) throws SQLException;
}
