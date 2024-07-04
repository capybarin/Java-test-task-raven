package com.example.customersapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, Object> result = new HashMap<>();
        result.put("status", ex.getStatusCode());
        result.put("errors", errors);
        result.put("timestamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
