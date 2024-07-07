package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("facundo")
                .lastModifiedDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .version(1)
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("carlo")
                .lastModifiedDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .version(1)
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("roman")
                .lastModifiedDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .version(2)
                .build();

        this.customerMap.put(customer1.getId(), customer1);
        this.customerMap.put(customer2.getId(), customer2);
        this.customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> allCustomers() {
        return this.customerMap.values().stream().toList();
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return this.customerMap.get(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .lastModifiedDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .version(customer.getVersion())
                .build();

        this.customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);
        existing.setCustomerName(customer.getCustomerName());
    }

    @Override
    public void deleteCustomerById(UUID id) {
        customerMap.remove(id);
    }

    @Override
    public void patchById(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);

        if (StringUtils.hasText(customer.getCustomerName())) {
            existing.setCustomerName(customer.getCustomerName());
        }
    }
}
