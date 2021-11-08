package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping("/seats")
    public TheaterDto getTheaterInformation() {
        return theaterService.getTheaterInformation();
    }

    @PostMapping("/purchase")
    public SeatDto purchaseTicket(@RequestBody SeatDto seatDto) {
        return theaterService.purchaseTicket(seatDto.getRow(), seatDto.getColumn());
    }
}
