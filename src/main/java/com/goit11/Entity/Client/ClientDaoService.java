package com.goit11.Entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDaoService {
    List<Client> listClients();
    void createClient(Client client) throws SQLException;
    Client getByIdClient(Long id) throws SQLException;
    void updateClient(long id,String name) throws  SQLException;
    void removeClient(Long id) throws SQLException;

}
