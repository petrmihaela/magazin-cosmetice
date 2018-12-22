package main;

import data_layer.dto.ErrorResponse;
import data_layer.exceptions.FailResponse;
import data_layer.exceptions.NotFoundException;
import data_layer.exceptions.OrderException;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {OrderException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleOrderException(RuntimeException ex, WebRequest request) {
        FailResponse failResponse = new FailResponse(ex.getMessage());

        return handleExceptionInternal(ex, failResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNotFoundException(NotFoundException se) {
        return new ErrorResponse(se.getErrorMessage());
    }

//    @ExceptionHandler(OrderException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handleOrderException(OrderException se) {
//        return new ErrorResponse(se.getErrorMessage());
//    }
}
