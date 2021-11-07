package cinema;

public class SeatDto {
    private int row;
    private int column;
    private Integer price;

    public SeatDto() {
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public SeatDto(Seat seat) {
        this.row = seat.getRow();
        this.column = seat.getColumn();
        this.price = seat.getPrice();
    }
}
