package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Seat with row %d and column %d is not found", row, column));
    }

    public SeatDto purchaseTicket(int row, int column) {
        if (column > theater.getTotalColumns() || row > theater.getTotalRows() || column < 1 || row < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                  "The number of a row or a column is out of bounds!");
        }
        Seat seat = getSeatByRowAndColumn(row, column);
        if (seat.isAvailable()) {
            seat.setAvailable(false);
            return new SeatDto(seat);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The ticket has been already purchased!");
        }
    }
}
