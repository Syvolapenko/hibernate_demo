import com.goit11.Entity.Client.Client;
import com.goit11.Entity.Client.ClientCrudService;
import com.goit11.Entity.Planet.Planet;
import com.goit11.Entity.Planet.PlanetCrudService;
import com.goit11.Flyway.FlywayApplication;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
//        new FlywayApplication()
//                .setup()
//                .migrate();
//        ClientCrudService crudService = new ClientCrudService();

//        crudService.update(13,"Roman");
//        denis.setName("Denis");
//        crudService.create(denis);
//        System.out.println("crudService.getById(6L) = " + crudService.getById(6L));
//        crudService.removeClient(12l);
//        System.out.println("crudService.listClients() = " + crudService.listClients());
        PlanetCrudService planetCrudService = new PlanetCrudService();

        planetCrudService.createPlanet("2","nae");
//        System.out.println("planetCrudService.getByIdPlanet(\"VEN2\") = " + planetCrudService.getByIdPlanet("VEN2"));
//        planetCrudService.updatePlanetByName("PLU6","URANUS");
//        planetCrudService.removePlanet("PLU6");
        System.out.println("planetCrudService.listPlanets() = " + planetCrudService.listPlanets());

    }
}
