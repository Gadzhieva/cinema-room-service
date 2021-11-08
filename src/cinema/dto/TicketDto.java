package cinema.dto;

import cinema.repository.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TicketDto {
    private SeatDto seat;
    private UUID token;

    @JsonProperty("ticket")
    public SeatDto getSeat() {
        return seat;
    }

    public UUID getToken() {
        return token;
    }

    public TicketDto(Ticket ticket) {
        this.seat = new SeatDto(ticket.getSeat());
        this.token = ticket.getToken();
    }
}
