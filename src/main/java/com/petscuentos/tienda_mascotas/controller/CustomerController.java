package com.petscuentos.tienda_mascotas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.util.List;
import com.petscuentos.tienda_mascotas.service.CustomerService;
import com.petscuentos.tienda_mascotas.model.Customer;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService bookingService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return bookingService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Optional<Customer>  getCustomerById(@PathVariable Integer id) {

        return bookingService.getCustomerById(id);
    }
    @PostMapping
    public Customer createCustomerEntity(@RequestBody Customer booking) {
       
        return   bookingService.createCustomer(booking);
    }
    @PutMapping("/{id}")
    public Customer  updateUser(@PathVariable Integer id, @RequestBody Customer booking) {

        return bookingService.updateCustomer(id, booking);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
         bookingService.deleteCustomer(id);
    }

}
