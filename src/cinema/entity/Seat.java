package cinema.entity;

public class Seat {
    public static final int MAX_EXPENSIVE_ROW = 4;
    public static final int EXPENSIVE_TICKET_PRICE = 10;
    public static final int CHEAP_TICKET_PRICE = 8;

    private final int row;
    private final int column;
    private final int price;
    private boolean available = true;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        if (row <= MAX_EXPENSIVE_ROW) {
            this.price = EXPENSIVE_TICKET_PRICE;
        } else {
            this.price = CHEAP_TICKET_PRICE;
        }
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
