package cinema.dto;

import cinema.repository.Seat;

public class SeatCoordinatesDto {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public SeatCoordinatesDto() {
    }

    public SeatCoordinatesDto(Seat seat) {
        this.row = seat.getRow();
        this.column = seat.getColumn();
    }
}
