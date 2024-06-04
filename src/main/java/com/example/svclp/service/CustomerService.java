package com.example.svclp.service;

import com.example.svclp.model.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id); 

    Customer saveCustomer(Customer customer);

    
}
