package main;

import data_layer.dto.ErrorResponse;
import data_layer.exceptions.NotFoundException;
import data_layer.exceptions.OrderException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNotFoundException(NotFoundException se) {
        return new ErrorResponse(se.getErrorMessage());
    }

    @ExceptionHandler(OrderException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOrderException(OrderException se) {
        return new ErrorResponse(se.getErrorMessage());
    }
}
