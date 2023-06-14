import com.goit11.Entity.Ticket.TicketCrudService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws IOException, SQLException, ParseException {
        TicketCrudService ticketCrudService = new TicketCrudService();
//          Create
//      Ticket firstTicket = new Ticket();
//      ticketCrudService.createTicket(firstTicket,8,"2037-07-23 17:12:48","VEN2","EAR5");
//          Read
//      System.out.println(ticketCrudService.getByIdTicket(2L));
//          Update
//        ticketCrudService.updateTicket(8L,"2017-07-23 17:12:48",4L);
//          Delete
        ticketCrudService.removeTicket(8L);
    }
}
