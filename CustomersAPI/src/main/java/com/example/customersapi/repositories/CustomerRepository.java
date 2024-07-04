package com.example.customersapi.repositories;

import com.example.customersapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findCustomersByIsActiveTrue();

    Customer getCustomerById(Integer id);

    Customer save(Customer customer);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET created=:#{#customer.created}, updated=:#{#customer.updated}, " +
            "full_name=:#{#customer.fullName}, email=:#{#customer.email}, phone=:#{#customer.phone}, " +
            "is_active=:#{#customer.isActive} WHERE id=:id ", nativeQuery = true)
    void updateCustomer(Integer id, @Param("customer") Customer updatedCustomer);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET is_active=FALSE WHERE id=:id", nativeQuery = true)
    void setIsActiveFalse(Integer id);
}
