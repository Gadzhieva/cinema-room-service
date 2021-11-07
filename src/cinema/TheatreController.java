package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

    @Autowired
    Theater theater;

    @GetMapping("/seats")
    public Theater getTheaterInformation() {
        return theater;
    }
}
