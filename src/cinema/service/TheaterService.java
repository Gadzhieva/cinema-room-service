package cinema.service;

import cinema.dto.SeatDto;
import cinema.dto.StatisticsDto;
import cinema.dto.TheaterDto;
import cinema.dto.TicketDto;
import cinema.entity.Seat;
import cinema.entity.Ticket;
import cinema.exception.NotFoundException;
import cinema.exception.SeatIsNotAvailableException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import cinema.repository.Theater;

import java.util.UUID;

public class TheaterService {

    private final Theater theater;

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
            throw new SeatIsNotAvailableException("The number of a row or a column is out of bounds!");
        }

        Seat seat = getSeatByRowAndColumn(row, column);
        if (!seat.isAvailable()) {
            throw new SeatIsNotAvailableException("The ticket has been already purchased!");
        }

        seat.setAvailable(false);
        Ticket ticket = new Ticket(seat, UUID.randomUUID());
        theater.addTicket(ticket);
        return new TicketDto(ticket);
    }

    private Ticket getTicketByToken(UUID token) {
        for (Ticket ticket : theater.getTickets()) {
            if (token.equals(ticket.getToken())) {
                return ticket;
            }
        }
        throw new WrongTokenException("Wrong token!");
    }

    public SeatDto returnTicket(UUID token) {
        Ticket ticket = getTicketByToken(token);
        Seat seat = ticket.getTicket();
        seat.setAvailable(true);
        theater.removeTicket(ticket);
        return new SeatDto(seat);
    }

    public StatisticsDto generateStatistics() {
        int purchasedTicketsNumber = theater.getTickets().size();
        int availableSeatsNumber = theater.getTotalColumns() * theater.getTotalRows() - purchasedTicketsNumber;

        int currentIncome = 0;
        for (Ticket ticket : theater.getTickets()) {
            currentIncome += ticket.getTicket().getPrice();
        }

        return new StatisticsDto(currentIncome, availableSeatsNumber, purchasedTicketsNumber);
    }

    public StatisticsDto returnStatistics(String password) {
        if (!"super_secret".equals(password)) {
            throw new WrongPasswordException("The password is wrong!");
        }
        return generateStatistics();
    }
}
