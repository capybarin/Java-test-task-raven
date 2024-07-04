package com.example.customersapi.services;

import com.example.customersapi.exceptions.NotFoundException;
import com.example.customersapi.models.Customer;
import com.example.customersapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException("Customer", id);
        return customerRepository.getCustomerById(id);
    }

    @Override
    public Customer save(Customer customer) {
        Customer tmpCustomer = new Customer();

        tmpCustomer.setFullName(customer.getFullName());
        tmpCustomer.setEmail(customer.getEmail());
        tmpCustomer.setIsActive(true);
        tmpCustomer.setCreated((int) Instant.now().getEpochSecond());
        tmpCustomer.setUpdated((int) Instant.now().getEpochSecond());
        tmpCustomer.setPhone(customer.getPhone());

        return customerRepository.save(tmpCustomer);
    }

    @Override
    public void updateCustomer(Integer id, Customer customer) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException("Customer", id);
        Customer existingCustomer = customerRepository.getCustomerById(id);
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setUpdated((int) Instant.now().getEpochSecond());

        customerRepository.updateCustomer(id, existingCustomer);
    }

    @Override
    public void setIsActiveFalse(Integer id) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException("Customer", id);
        customerRepository.setIsActiveFalse(id);
    }


}
