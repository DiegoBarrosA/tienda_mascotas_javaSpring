package com.petscuentos.tienda_mascotas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static List<Customer> customers = new ArrayList<>();

public CustomerController(){
 int id;
 String firstName;
 String middleName;
 String lastName;
 String address;
 String emailAddress;

 customers.add(new Customer(1,"Diego", "Pablo", "Barros Araya", "Calle Vieja 123", "dba@example.com"));
 customers.add(new Customer(2,"Jane", "Kermit", "Doe", "Old street 219", "j.k.d@example.com"));
 customers.add(new Customer(3,"Kevin", "Martin", "Dawkins", "New street 929", "KMartin.D@example.com"));
 customers.add(new Customer(4,"Valentine", "Douglas", "Kale", "First Aveneu 123", "ValD.k@example.com"));

}

@GetMapping("/customer")
public List<Customer> getCustomers() {
    return customers;
}

@GetMapping("/customer/{id}")
public Customer getCustomerById(@PathVariable("id") int id) {
    for (Customer customer : customers) {
        if (customer.getId() == id) {
            return customer;
        }
    };
    return null;
}

}
