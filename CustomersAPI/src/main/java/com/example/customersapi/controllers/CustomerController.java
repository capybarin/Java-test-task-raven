package com.example.customersapi.controllers;

import com.example.customersapi.models.Customer;
import com.example.customersapi.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping(path = "/api/customers", consumes = "application/json", produces = "application/json")
    public List<Customer> listCustomers(){
        return customerServiceImpl.findCustomersByIsActiveTrue();
    }

    @GetMapping(path = "/api/customers/{id}", consumes = "application/json", produces = "application/json")
    public Customer getCustomer(@PathVariable Integer id){
        return customerServiceImpl.getCustomerById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/api/customers/{id}", consumes = "application/json", produces = "application/json")
    public void deleteCustomer(@PathVariable Integer id){
        customerServiceImpl.setIsActiveFalse(id);
    }
}
