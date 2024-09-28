package com.petscuentos.tienda_mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petscuentos.tienda_mascotas.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer > {
    Customer findCustomerByFirstName(String firstName);

}
