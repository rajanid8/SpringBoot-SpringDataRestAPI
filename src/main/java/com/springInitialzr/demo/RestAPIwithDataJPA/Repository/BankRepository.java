package com.springInitialzr.demo.RestAPIwithDataJPA.Repository;

import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, String> {
}
