package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.petscuentos.tienda_mascotas.model.Customer;
import com.petscuentos.tienda_mascotas.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
@Autowired

 private  CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
      return  customerRepository.save(customer);
    }
    
    @Override
    public Optional<Customer>  getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {
        if(customerRepository.existsById(id)){
            customer.setId(id);
            return customerRepository.save(customer);
        }else{return null; }    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findCustomerByFirstName(String firstName) {
        logger.info("Finding user by first name: {} - method findCustomerByName", firstName);
        return customerRepository.findCustomerByFirstName(firstName);
    }
}
