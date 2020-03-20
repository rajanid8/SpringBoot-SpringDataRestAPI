package com.springInitialzr.demo.RestAPIwithDataJPA.service;

import com.springInitialzr.demo.RestAPIwithDataJPA.Repository.CustomerRepository;
import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;
import com.springInitialzr.demo.RestAPIwithDataJPA.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomerDetails(String id) {
        List<Customer> customerDetails = new ArrayList<>();
        customerRepository.findByBankId(id)
                .forEach(customerDetails::add);
        return customerDetails;
    }

    public Optional<Customer> getCustomer(String id){
        return customerRepository.findById(id);
    }

    public void addCustomer(Customer customer){

        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
