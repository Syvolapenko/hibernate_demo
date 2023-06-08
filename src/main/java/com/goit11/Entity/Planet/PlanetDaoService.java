package com.goit11.Entity.Planet;



import java.sql.SQLException;
import java.util.List;

public interface PlanetDaoService {
    List<Planet> listPlanets();
    void createPlanet(String id,String name) throws SQLException;
    Planet getByIdPlanet(String id) throws SQLException;
    void updatePlanetByName(String id,String name) throws  SQLException;
    void removePlanet(String id) throws SQLException;
}
