package cinema.config;

import cinema.dto.ExceptionDto;
import cinema.exception.NotFoundException;
import cinema.exception.SeatIsNotAvailableException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {SeatIsNotAvailableException.class})
    protected ResponseEntity<ExceptionDto> handleSeatIsNotAvailable(SeatIsNotAvailableException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ExceptionDto> handleSeatNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {WrongTokenException.class})
    protected ResponseEntity<ExceptionDto> handleWrongToken(WrongTokenException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {WrongPasswordException.class})
    protected ResponseEntity<ExceptionDto> handleWrongPassword(WrongPasswordException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}

