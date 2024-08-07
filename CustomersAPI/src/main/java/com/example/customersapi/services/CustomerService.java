package com.example.customersapi.services;

import com.example.customersapi.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findCustomersByIsActiveTrue();
    Customer getCustomerById(Integer id);
    void updateCustomer(Integer id, Customer customer);
    Customer save(Customer customer);
    void setIsActiveFalse(Integer id);
}
