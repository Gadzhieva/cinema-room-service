package cinema;

public class Seat {
    int row;
    int column;
    int price;
    boolean available = true;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        if (row <= 4) {
            price = 10;
        } else {
            price = 8;
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
