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


    //Returns all customer with is_active=true, skips others
    @Override
    public List<Customer> findCustomersByIsActiveTrue(){
        return customerRepository.findCustomersByIsActiveTrue();
    }


    //Returns a customer by ID, throws a 404 error if not found
    @Override
    public Customer getCustomerById(Integer id) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException("Customer", id);

        return customerRepository.getCustomerById(id);
    }


    //Saves a customer, writes only fullName, email and phone fields, others are being filled automatically
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


    //Updates a customer, writes only fullName and phone, ignores other fields
    @Override
    public void updateCustomer(Integer id, Customer customer) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException("Customer", id);

        Customer existingCustomer = customerRepository.getCustomerById(id);
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setUpdated((int) Instant.now().getEpochSecond());

        customerRepository.updateCustomer(id, existingCustomer);
    }


    //Marks a customer as is_active=false
    @Override
    public void setIsActiveFalse(Integer id) {
        if(customerRepository.getCustomerById(id) == null) throw new NotFoundException("Customer", id);

        customerRepository.setIsActiveFalse(id);
    }
}
