package cinema;

import cinema.dto.TheaterDto;
import cinema.dto.TicketDto;
import cinema.repository.Seat;
import cinema.repository.Theater;
import cinema.repository.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class TheaterService {

    @Autowired
    private Theater theater;

    public TheaterService(Theater theater) {
        this.theater = theater;
    }

    public TheaterDto getTheaterInformation() {
        return new TheaterDto(theater);
    }

    private Seat getSeatByRowAndColumn(int row, int column) {
        for (Seat seat : theater.getAllSeats()) {
            if (seat.getColumn() == column && seat.getRow() == row) {
                return seat;
            }
        }
        throw new NotFoundException(String.format("Seat with row %d and column %d is not found", row, column));
    }

    public TicketDto purchaseTicket(int row, int column) {
        if (column > theater.getTotalColumns() || row > theater.getTotalRows() || column < 1 || row < 1) {
            throw new SeatIsNotAvailable("The number of a row or a column is out of bounds!");
        }

        Seat seat = getSeatByRowAndColumn(row, column);
        if (!seat.isAvailable()) {
            throw new SeatIsNotAvailable("The ticket has been already purchased!");
        }

        seat.setAvailable(false);
        Ticket ticket = new Ticket(seat, UUID.randomUUID());
        theater.addTickets(ticket);
        return new TicketDto(ticket);
    }

    private Ticket getTicketByToken(UUID token) {
        for (Ticket ticket: theater.getTickets()) {
            if (token.equals(ticket.getToken())) {
                return ticket;
            }
        }
        throw new WrongTokenException("Wrong token!");
    }

    public TicketDto returnTicket(UUID token) {
        Ticket ticket = getTicketByToken(token);
        Seat seat = ticket.getSeat();
        seat.setAvailable(true);
        theater.removeTickets(ticket);
        return new TicketDto(ticket);
    }
}
