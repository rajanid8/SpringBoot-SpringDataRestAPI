package com.springInitialzr.demo.RestAPIwithDataJPA.Repository;

import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;
import com.springInitialzr.demo.RestAPIwithDataJPA.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    public List<Customer> findByBankId(String bankId);

}
