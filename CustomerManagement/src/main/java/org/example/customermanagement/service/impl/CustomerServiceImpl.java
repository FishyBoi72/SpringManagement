package org.example.customermanagement.service.impl;

import org.example.customermanagement.model.Customer;
import org.example.customermanagement.service.CustomerService;
import org.example.customermanagement.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers = new ArrayList<>();
    private NotificationService notificationService;

    @Autowired
    public CustomerServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        notificationService.sendNotification(customer);
        System.out.println("Customer added: " + customer.getName());
    }

    @Override
    public Customer getCustomer(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer existingCustomer = getCustomer(customer.getId());
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setContactNumber(customer.getContactNumber());
            System.out.println("Customer updated: " + customer.getName());
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
        System.out.println("Customer deleted with ID: " + id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
