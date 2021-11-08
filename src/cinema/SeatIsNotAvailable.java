package cinema;

public class SeatIsNotAvailable extends RuntimeException {
    public SeatIsNotAvailable(String message) {
        super(message);
    }
}
