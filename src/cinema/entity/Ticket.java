package cinema.entity;

import java.util.UUID;

public class Ticket {
    private final Seat ticket;
    private final UUID token;

    public Seat getTicket() {
        return ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Ticket(Seat seat, UUID token) {
        this.ticket = seat;
        this.token = token;
    }
}
