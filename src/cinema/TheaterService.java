package cinema;

import org.springframework.beans.factory.annotation.Autowired;

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
        throw new SeatNotFoundException(String.format("Seat with row %d and column %d is not found", row, column));
    }

    public SeatDto purchaseTicket(int row, int column) {
        if (column > theater.getTotalColumns() || row > theater.getTotalRows() || column < 1 || row < 1) {
            throw new SeatIsNotAvailable("The number of a row or a column is out of bounds!");
        }

        Seat seat = getSeatByRowAndColumn(row, column);
        if (!seat.isAvailable()) {
            throw new SeatIsNotAvailable("The ticket has been already purchased!");
        }

        seat.setAvailable(false);
        return new SeatDto(seat);
    }
}
