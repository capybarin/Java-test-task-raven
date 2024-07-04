package com.example.customersapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException (String objectType, Integer id){
        super(objectType + " with id \"" + id + "\" does not exist.");
    }
}
