package com.petscuentos.tienda_mascotas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petscuentos.tienda_mascotas.model.Customer;
import com.petscuentos.tienda_mascotas.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
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
}
