package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> allCustomers();
    Customer getCustomerById(UUID id);
    Customer saveCustomer(Customer customer);
    void updateCustomerById(UUID id, Customer customer);
    void deleteCustomerById(UUID id);
    void patchById(UUID id, Customer customer);
}
