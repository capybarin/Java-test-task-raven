package com.example.customersapi.controllers;

import com.example.customersapi.models.Customer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @GetMapping(path = "/api/customers", consumes = "application/json", produces = "application/json")
    public List<Customer> listCustomers(){
        return null;
    }
}
