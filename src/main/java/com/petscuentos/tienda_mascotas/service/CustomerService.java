package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.petscuentos.tienda_mascotas.model.Customer;
import java.util.Optional;

@Service
public interface CustomerService {
  List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Optional<Customer>  getCustomerById(Integer id);
    Customer findCustomerByFirstName(String firstName);
    Customer updateCustomer(Integer id, Customer customer);
    void deleteCustomer(Integer id);
}
