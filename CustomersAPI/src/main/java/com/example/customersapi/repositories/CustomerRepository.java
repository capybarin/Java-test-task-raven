package com.example.customersapi.repositories;

import com.example.customersapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findCustomersByIsActiveTrue();
    Customer getCustomerById(Integer id);
    /*Customer save(Customer customer);
    Customer updateById(Integer id, Customer updatedCustomer);*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET is_active=FALSE WHERE id=:id", nativeQuery = true)
    void setIsActiveFalse(Integer id);
}
