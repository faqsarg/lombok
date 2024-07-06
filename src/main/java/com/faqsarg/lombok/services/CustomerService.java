package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> allCustomers();
    Customer getCustomerById(UUID id);
}
