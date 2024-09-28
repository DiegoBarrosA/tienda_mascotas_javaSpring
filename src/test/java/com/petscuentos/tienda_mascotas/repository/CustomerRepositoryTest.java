package com.petscuentos.tienda_mascotas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.petscuentos.tienda_mascotas.controller.CustomerController;
import com.petscuentos.tienda_mascotas.model.Customer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CustomerRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setMiddleName("D.");
        customer.setLastName("Doe");

        Customer result = customerRepository.save(customer);
        assertNotNull(result.getId());
        assertEquals("John",result.getFirstName());
        logger.info("Returned {}",result.getFirstName());
        assertEquals("D.",result.getMiddleName());
        logger.info("Returned {}",result.getMiddleName());
        assertEquals("Doe",result.getLastName());
        logger.info("Returned {}",result.getLastName());

    }

}