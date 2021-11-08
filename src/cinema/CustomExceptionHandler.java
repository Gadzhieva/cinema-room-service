package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {SeatIsNotAvailable.class})
    protected ResponseEntity<ExceptionDto> handleSeatIsNotAvaliable(SeatIsNotAvailable ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {SeatNotFoundException.class})
    protected ResponseEntity<ExceptionDto> handleSeatNotFound(SeatNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}

