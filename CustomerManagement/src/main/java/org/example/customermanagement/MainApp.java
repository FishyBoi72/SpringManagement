package org.example.customermanagement;

import org.example.customermanagement.model.Customer;
import org.example.customermanagement.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.customermanagement")
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        CustomerService customerService = context.getBean(CustomerService.class);

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Fish");
        customer1.setEmail("fish@example.com");
        customer1.setContactNumber("1234567890");

        customerService.addCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Dewey");
        customer2.setEmail("dewey@example.com");
        customer2.setContactNumber("0987654321");

        customerService.addCustomer(customer2);

        Customer customer = customerService.getCustomer(1L);
        System.out.println("Retrieved Customer: " + customer.getName());

        customer.setName("Fisher");
        customerService.updateCustomer(customer);

        customerService.deleteCustomer(2L);

        customerService.getAllCustomers().forEach(c -> System.out.println("Customer: " + c.getName()));
    }
}
