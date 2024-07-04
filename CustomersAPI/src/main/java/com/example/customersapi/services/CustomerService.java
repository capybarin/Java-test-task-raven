package com.example.customersapi.services;

import com.example.customersapi.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
}
