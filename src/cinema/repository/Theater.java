package cinema.repository;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    private final List<Seat> allSeats;
    private List<Ticket> tickets;

    public Theater() {
        allSeats = new ArrayList<>();
        tickets = new ArrayList<>();
        for (int i = 1; i <= TOTAL_ROWS; i++) {
            for (int j = 1; j <= TOTAL_COLUMNS; j++) {
                allSeats.add(new Seat(i, j));
            }
        }
    }


    public int getTotalRows() {
        return TOTAL_ROWS;
    }

    public int getTotalColumns() {
        return TOTAL_COLUMNS;
    }
    public List<Seat> getAllSeats() {
        return allSeats;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTickets(Ticket ticket) {
        this.tickets.remove(ticket);
    }
}
