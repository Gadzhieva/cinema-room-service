package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    private final List<Seat> avaliableSeats;

    public Theater() {
        avaliableSeats = new ArrayList<>();
        for (int i = 1; i <= TOTAL_ROWS; i++) {
            for (int j = 1; j <= TOTAL_COLUMNS; j++) {
                avaliableSeats.add(new Seat(i, j));
            }
        }
    }

    @JsonProperty("total_rows")
    public int getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    @JsonProperty("total_columns")
    public int getTOTAL_COLUMNS() {
        return TOTAL_COLUMNS;
    }

    @JsonProperty("available_seats")
    public List<Seat> getAvaliable_seats() {
        return avaliableSeats;
    }
}
