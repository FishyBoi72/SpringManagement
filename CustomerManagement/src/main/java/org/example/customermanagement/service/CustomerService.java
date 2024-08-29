package org.example.customermanagement.service;

import org.example.customermanagement.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomer(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}
