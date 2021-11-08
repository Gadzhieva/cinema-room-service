package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private final int TOTAL_ROWS = 9;
    private final int TOTAL_COLUMNS = 9;
    private final List<Seat> allSeats;

    public Theater() {
        allSeats = new ArrayList<>();
        for (int i = 1; i <= TOTAL_ROWS; i++) {
            for (int j = 1; j <= TOTAL_COLUMNS; j++) {
                allSeats.add(new Seat(i, j));
            }
        }
    }


    public int getTotalRows() {
        return TOTAL_ROWS;
    }

    public int getTotalColumns() {
        return TOTAL_COLUMNS;
    }
    public List<Seat> getAllSeats() {
        return allSeats;
    }
}
