package com.example.customersapi.services;

import com.example.customersapi.exceptions.NotFoundException;
import com.example.customersapi.models.Customer;
import com.example.customersapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        if(customerRepository.getCustomerById(id) != null) return customerRepository.getCustomerById(id);
        else throw new NotFoundException();
    }


}
