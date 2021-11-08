package cinema;

import cinema.dto.*;
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
    public TicketDto purchaseTicket(@RequestBody SeatCoordinatesDto seatCoordinatesDto) {
        return theaterService.purchaseTicket(seatCoordinatesDto.getRow(), seatCoordinatesDto.getColumn());
    }

    @PostMapping("/return")
    public TicketDto returnTicket(@RequestBody TokenDto tokenDto) {
        return theaterService.returnTicket(tokenDto.getToken());
    }
}
