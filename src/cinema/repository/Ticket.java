package cinema.repository;

import java.util.UUID;

public class Ticket {
    private Seat seat;
    private UUID token;

    public Seat getSeat() {
        return seat;
    }

    public UUID getToken() {
        return token;
    }

    public Ticket(Seat seat, UUID token) {
        this.seat = seat;
        this.token = token;
    }
}
