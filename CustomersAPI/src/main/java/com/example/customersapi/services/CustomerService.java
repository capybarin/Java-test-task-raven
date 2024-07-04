package com.example.customersapi.services;

import com.example.customersapi.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listCustomers();
    Customer getCustomer(Integer id);
    Customer createCustomer(Customer newCustomer);
    Customer updateCustomer(Integer id, Customer updatedCustomer);
    void deleteCustomer(Integer id);
}
