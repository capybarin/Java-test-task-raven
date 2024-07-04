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
    public List<Customer> findCustomersByIsActiveTrue(){
        return customerRepository.findCustomersByIsActiveTrue();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException();
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void setIsActiveFalse(Integer id) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException();
        customerRepository.setIsActiveFalse(id);
    }


}
