package com.springInitialzr.demo.RestAPIwithDataJPA.service;

import com.springInitialzr.demo.RestAPIwithDataJPA.Repository.BankRepository;
import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public List<Bank> getAllBankDetails() {
        List<Bank> bankDetails = new ArrayList<>();
        bankRepository.findAll()
                .forEach(bankDetails::add);
        return bankDetails;
    }

    public Optional<Bank> getBank(String id){
        return bankRepository.findById(id);
    }

    public void addBank(Bank bank){
        bankRepository.save(bank);
    }

    public void updateBank(Bank bank, String id) {
        bankRepository.save(bank);
    }


    public void deleteBank(String id) {
        bankRepository.deleteById(id);
    }
}


