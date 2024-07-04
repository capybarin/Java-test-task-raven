package com.example.customersapi.controllers;

import com.example.customersapi.models.Customer;
import com.example.customersapi.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping(path = "/api/customers", consumes = "application/json", produces = "application/json")
    public List<Customer> listCustomers(){
        System.out.println("here");
        return customerServiceImpl.findAll();
    }
}
