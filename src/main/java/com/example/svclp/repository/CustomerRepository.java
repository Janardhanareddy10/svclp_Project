package com.example.svclp.repository;

import com.example.svclp.model.Customer;
import com.example.svclp.model.LoyaltyPoints;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer  findByCustomerAccountNumber(Long id);
    
}
