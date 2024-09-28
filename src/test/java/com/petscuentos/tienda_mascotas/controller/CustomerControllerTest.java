package com.petscuentos.tienda_mascotas.controller;

import com.petscuentos.tienda_mascotas.model.Customer;
import com.petscuentos.tienda_mascotas.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setId(1);
        customer.setAddress("Test Address 47");
        customer.setEmailAddress("john.doe@example.com");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setMiddleName("D.");
    }


    
    @Test
    void createCustomer() {
        // Arrange
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        // Act
        ResponseEntity<EntityModel<Customer>> response = customerController.createCustomer(customer);
        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        EntityModel<Customer> savedCustomerModel = response.getBody();
        assertNotNull(savedCustomerModel);
        assertEquals(customer.getId(), savedCustomerModel.getContent().getId());
        assertTrue(savedCustomerModel.hasLink("self"));
        verify(customerService).createCustomer(any(Customer.class));
    }

    @SuppressWarnings("null")
    @Test
    void getCustomerById_found() {
        // Arrange
        when(customerService.getCustomerById(1)).thenReturn(Optional.of(customer));

        // Act
        ResponseEntity<EntityModel<Customer>> response = customerController.getCustomerById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Customer> foundCustomerModel = response.getBody();
        assertNotNull(foundCustomerModel);
        assertEquals(customer.getId(), foundCustomerModel.getContent().getId());
        assertTrue(foundCustomerModel.hasLink("self"));
        verify(customerService).getCustomerById(1);
    }

    @Test
    void getCustomerById_notFound() {
        // Arrange
        when(customerService.getCustomerById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<EntityModel<Customer>> response = customerController.getCustomerById(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(customerService).getCustomerById(1);
    }

    @SuppressWarnings("null")
    @Test
    void getCustomerByFirstName_found() {
        // Arrange
        when(customerService.findCustomerByFirstName("testcustomer")).thenReturn(customer);

        // Act
        ResponseEntity<EntityModel<Customer>> response = customerController.getCustomerByFirstName("testcustomer");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Customer> foundCustomerModel = response.getBody();
        assertNotNull(foundCustomerModel);
        assertEquals(customer.getFirstName(), foundCustomerModel.getContent().getFirstName());
        assertTrue(foundCustomerModel.hasLink("self"));
        verify(customerService).findCustomerByFirstName("testcustomer");
    }

    @Test
    void getCustomerByFirstName_notFound() {
        // Arrange
        when(customerService.findCustomerByFirstName("testcustomer")).thenReturn(null);

        // Act
        ResponseEntity<EntityModel<Customer>> response = customerController.getCustomerByFirstName("testcustomer");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(customerService).findCustomerByFirstName("testcustomer");
    }

    @Test
    void getAllCustomers() {
        // Arrange
        List<Customer> customerList = List.of(customer);
        when(customerService.getAllCustomers()).thenReturn(customerList);

        // Act
        ResponseEntity<CollectionModel<EntityModel<Customer>>> response = customerController.getAllCustomers();
        CollectionModel<EntityModel<Customer>> foundCustomersModel = response.getBody();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(foundCustomersModel);
        assertEquals(1, foundCustomersModel.getContent().size());
        assertTrue(foundCustomersModel.hasLink("self"));
        verify(customerService).getAllCustomers();
    }

    @Test
    void deleteCustomer() {
        // Arrange
        doNothing().when(customerService).deleteCustomer(1);

        // Act
        ResponseEntity<Void> response = customerController.deleteCustomer(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(customerService).deleteCustomer(1);
    }
}