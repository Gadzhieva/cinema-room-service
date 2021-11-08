package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TheaterDto {

    @JsonProperty("total_rows")
    private int totalRows;

    @JsonProperty("total_columns")
    private int totalColumns;

    @JsonProperty("available_seats")
    private List<SeatDto> availableSeats;

    public TheaterDto(Theater theater) {
        this.totalColumns = theater.getTotalColumns();
        this.totalRows = theater.getTotalRows();
        this.availableSeats = new ArrayList<>();
        for (Seat seat: theater.getAllSeats()) {
            if (seat.isAvailable()) {
                this.availableSeats.add(new SeatDto(seat));
            }
        }
    }

}
