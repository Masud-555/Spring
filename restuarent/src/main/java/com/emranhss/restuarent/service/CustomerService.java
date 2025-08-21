package com.emranhss.restuarent.service;

import com.emranhss.restuarent.entity.Customer;
import com.emranhss.restuarent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer getProfileByUserId(Long userId) {
        return customerRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }





}
