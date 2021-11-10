package cinema.dto;

import cinema.entity.Seat;

public class SeatDto {
    private int row;
    private int column;
    private int price;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public SeatDto() {
    }

    public SeatDto(Seat seat) {
        this.row = seat.getRow();
        this.column = seat.getColumn();
        this.price = seat.getPrice();
    }
}
