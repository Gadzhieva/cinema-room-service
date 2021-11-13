package cinema.controller;

import cinema.dto.*;
import cinema.service.TheaterService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/seats")
    public TheaterDto getTheaterInformation() {
        return theaterService.getTheaterInformation();
    }

    @PostMapping("/purchase")
    public TicketDto purchaseTicket(@RequestBody SeatCoordinatesDto seatCoordinatesDto) {
        return theaterService.purchaseTicket(seatCoordinatesDto.getRow(), seatCoordinatesDto.getColumn());
    }

    @PostMapping("/return")
    public Map<String, SeatDto> returnTicket(@RequestBody TokenDto tokenDto) {
        return Map.of("returned_ticket", theaterService.returnTicket(tokenDto.getToken()));
    }

    @PostMapping("/stats")
    public StatisticsDto returnStatistics(@RequestParam(required = false) String password) {
        return theaterService.returnStatistics(password);
    }
}
