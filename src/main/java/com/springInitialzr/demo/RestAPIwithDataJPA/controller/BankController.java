package com.springInitialzr.demo.RestAPIwithDataJPA.controller;

import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;
import com.springInitialzr.demo.RestAPIwithDataJPA.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    /* Method to get all the Bank details
     * in postman:
     * GET: http://localhost:8080/bankDetails/
     * Response:
     * [
            {
                "id": "102",
                "bankName": "ICICI",
                "branch": "Kondapur Branch",
                "ifscCode": "ICIC00123",
                "address": "Kondapur, Hyderabad"
            },
            {
                "id": "101",
                "bankName": "HDFC",
                "branch": "Madhapur Branch",
                "ifscCode": "HDFC00123",
                "address": "CyberTowers, Madhapur, Hyderabad"
            }
        ]
     */
    @RequestMapping(value="/bankDetails")
    public ResponseEntity<Collection<Bank>> getAllBankDetails() {
        List bankDetailsRepo = bankService.getAllBankDetails();
        return new ResponseEntity<>(bankDetailsRepo, HttpStatus.OK);
    }


    /* Method to get a particular bank data
     * in postman:
     * GET: http://localhost:8080/bankDetails/102
     * returns ICICI bank details
     * */
    @RequestMapping(value="/bankDetails/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable String id){
        Optional<Bank> bank = bankService.getBank(id);
        return new ResponseEntity(bank, HttpStatus.OK);
    }

    /* Method to add a new bank data
     * in postman:
     * Post: http://localhost:8080/bankDetails/
     * Body:
     * {
            "id": "101",
            "bankName": "HDFC",
            "branch": "Madhapur Branch",
            "ifscCode": "HDFC001234",
            "address": "Madhapur, Hyderabad"
        }
     * Headers:
     *  Key: Content-Type, Value: application/json
     * returns Bank Added Successfully
     *
     * If we run GET request now we will get response newly added bank along with previous bank details
     * */
    @RequestMapping(method= RequestMethod.POST, value="/bankDetails")
    public ResponseEntity<String> addBank(@RequestBody Bank bank){
        bankService.addBank(bank);
        return new ResponseEntity<>("Bank Added Successfully", HttpStatus.OK);
    }

    /* Method to update a particular bank details
     * in postman:
     * PUT: http://localhost:8080/bankDetails/101
     * Body:
     * {
            "id": "101",
            "bankName": "HDFC",
            "branch": "Madhapur Branch",
            "ifscCode": "HDFC001234",
            "address": "MediCover Hospitals, Madhapur, Hyderabad"
        }
     * Headers:
     *  Key: Content-Type, Value: application/json
     * returns Bank Added Successfully
     *
     * If we run GET request now we will get response updated bank details along with existing bank details.
     * */
    @RequestMapping(method= RequestMethod.PUT, value="/bankDetails/{id}")
    public ResponseEntity<String> updateBank(@RequestBody Bank bank, @PathVariable String id ){
        bankService.updateBank(bank, id);
        return new ResponseEntity<>("Bank Updated Successfully", HttpStatus.OK);
    }

    /* Method to delete a particular bank details
     * in postman:
     * DELETE: http://localhost:8080/bankDetails/101

     * returns Bank Deleted Successfully
     *
     * If we run GET request now we will get response only with existing bank details.
     * */
    @RequestMapping(method= RequestMethod.DELETE, value="/bankDetails/{id}")
    public ResponseEntity<String> deleteBank(@PathVariable String id ){
        bankService.deleteBank(id);
        return new ResponseEntity<>("Bank Deleted Successfully", HttpStatus.OK);
    }

}
