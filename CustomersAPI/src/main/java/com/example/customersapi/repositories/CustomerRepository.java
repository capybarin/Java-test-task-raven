package com.example.customersapi.repositories;

import com.example.customersapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();
    Customer getCustomerById(Integer id);
    /*Customer save(Customer customer);
    Customer updateById(Integer id, Customer updatedCustomer);
    void deleteById(Integer id);*/
}
