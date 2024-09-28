package com.petscuentos.tienda_mascotas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
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
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Customer>>> getAllCustomers() {
        logger.info("Getting all customers");
        List<EntityModel<Customer>> customers = customerService.getAllCustomers().stream()
                .map(customer -> {
                    EntityModel<Customer> customerModel = EntityModel.of(customer);
                    customerModel.add(
                            linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
                    return customerModel;
                }).toList();

        return ResponseEntity.ok(CollectionModel.of(customers,
                linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> getCustomerById(@PathVariable Integer id) {
        logger.info("Getting a customer by ID: {}", id);
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            EntityModel<Customer> customerModel = EntityModel.of(customer.get());
            customerModel.add(linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel());
            return ResponseEntity.ok(customerModel);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

  
    @PostMapping()
    public ResponseEntity<EntityModel<Customer>> createCustomer(@RequestBody Customer customer) {
        logger.info("Creating a new customer with request: {}", customer);
        Customer savedCustomer = customerService.createCustomer(customer);
        logger.info("Customer created successfully. Customer ID: {}", savedCustomer.getId());

        EntityModel<Customer> customerModel = EntityModel.of(savedCustomer);
        customerModel.add(linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel());

        return ResponseEntity.created(
                linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).toUri())
                .body(customerModel);
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        logger.info("Deleting a customer with ID: {}", id);
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/customer/name/first/{firstname}")
    public ResponseEntity<EntityModel<Customer>> getCustomerByFirstName(@PathVariable String firstname) {
        logger.info("Getting a customer by first name: {}", firstname);
        Customer customer = customerService.findCustomerByFirstName(firstname);
        if (customer != null) {
            EntityModel<Customer> customerModel = EntityModel.of(customer);
            customerModel.add(linkTo(methodOn(CustomerController.class).getCustomerByFirstName(firstname)).withSelfRel());

            return ResponseEntity.ok(customerModel);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
