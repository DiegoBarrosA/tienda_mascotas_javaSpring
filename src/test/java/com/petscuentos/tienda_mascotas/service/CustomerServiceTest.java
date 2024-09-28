package com.petscuentos.tienda_mascotas.service;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petscuentos.tienda_mascotas.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.petscuentos.tienda_mascotas.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private CustomerRepository customerRepositoryMock;
    @Test
    public void saveCustomerTest() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setMiddleName("D.");
        customer.setLastName("Doe");
        customer.setEmailAddress("john.doe@example.com");
        when(customerRepositoryMock.save(any())).thenReturn(customer);
        Customer result = customerService.createCustomer(customer);
        assertEquals("John", result.getFirstName());
        assertEquals("D.", result.getMiddleName());
        assertEquals("Doe", result.getLastName());
        assertEquals("john.doe@example.com", result.getEmailAddress());
    }
}
