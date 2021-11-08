package cinema.exception;

public class SeatIsNotAvailableException extends RuntimeException {
    public SeatIsNotAvailableException(String message) {
        super(message);
    }
}
