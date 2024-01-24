package com.juhmaran.showcase.testingrestapi.exceptions.handler;

import com.juhmaran.showcase.testingrestapi.exceptions.PersonNotFoundException;
import com.juhmaran.showcase.testingrestapi.exceptions.ResourceNotFoundException;
import com.juhmaran.showcase.testingrestapi.exceptions.dto.ErrorStatus;
import com.juhmaran.showcase.testingrestapi.exceptions.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request) {
        var response = ExceptionResponse.builder()
                .code(ErrorStatus.INTERNAL_SERVER_ERROR.getCode())
                .status(ErrorStatus.INTERNAL_SERVER_ERROR.getStatus())
                .message(ErrorStatus.INTERNAL_SERVER_ERROR.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handlePersonNotFoundException(
            Exception ex, WebRequest request) {
        var response = ExceptionResponse.builder()
                .code(ErrorStatus.NOT_FOUND.getCode())
                .status(ErrorStatus.NOT_FOUND.getStatus())
                .message(ErrorStatus.NOT_FOUND.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
            Exception ex, WebRequest request) {

        var response = ExceptionResponse.builder()
                .code(ErrorStatus.NOT_FOUND.getCode())
                .status(ErrorStatus.NOT_FOUND.getStatus())
                .message(ErrorStatus.NOT_FOUND.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
