package cinema.dto;

import cinema.entity.Ticket;

import java.util.UUID;

public class TicketDto {
    private final SeatDto ticket;
    private final UUID token;

    public SeatDto getTicket() {
        return ticket;
    }

    public UUID getToken() {
        return token;
    }

    public TicketDto(Ticket ticket) {
        this.ticket = new SeatDto(ticket.getTicket());
        this.token = ticket.getToken();
    }
}
