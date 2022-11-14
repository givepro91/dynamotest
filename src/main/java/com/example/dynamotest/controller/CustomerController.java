package com.example.dynamotest.controller;

import com.example.dynamotest.entity.Customer;
import com.example.dynamotest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping("/add/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @GetMapping("/get/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") String customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @DeleteMapping("/delete/customer/{id}")
    public String deleteCustomerById(@PathVariable("id") String customerId) {
        return  customerRepository.deleteCustomerById(customerId);
    }

    @PutMapping("/update/customer/{id}")
    public String updateCustomer(@PathVariable("id") String customerId, @RequestBody Customer customer) {
        return customerRepository.updateCustomer(customerId,customer);
    }
}
