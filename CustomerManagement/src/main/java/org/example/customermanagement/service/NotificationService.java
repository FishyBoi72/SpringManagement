package org.example.customermanagement.service;

import org.example.customermanagement.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(Customer customer) {
        System.out.println("Notification sent to customer: " + customer.getEmail());
    }
}
