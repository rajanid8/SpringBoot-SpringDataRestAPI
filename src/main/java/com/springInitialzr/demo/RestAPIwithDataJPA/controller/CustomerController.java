package com.springInitialzr.demo.RestAPIwithDataJPA.controller;

import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;
import com.springInitialzr.demo.RestAPIwithDataJPA.model.Customer;
import com.springInitialzr.demo.RestAPIwithDataJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

        @Autowired
        private CustomerService customerService;

        /* Method to get all the Customer details of that particular bank
         * in postman:
         * GET: http://localhost:8080/bankDetails/102/customerDetails
         * Response:
         * [
                {
                    "id": "1001",
                    "customerName": "Mr Mahesh",
                    "mobile": "9912345678",
                    "address": "Madhapur, Hyderabad",
                    "bank": {
                        "id": "102",
                        "bankName": "ICICI",
                        "branch": "Kondapur Branch",
                        "ifscCode": "ICIC00123",
                        "address": "Kondapur, Hyderabad"
                    }
                },
                {
                    "id": "1002",
                    "customerName": "Mr Sathvik",
                    "mobile": "987634832",
                    "address": "Kothaguda, Hyderabad",
                    "bank": {
                        "id": "102",
                        "bankName": "ICICI",
                        "branch": "Kondapur Branch",
                        "ifscCode": "ICIC00123",
                        "address": "Kondapur, Hyderabad"
                    }
                }
           ]
         */
        @RequestMapping(value="/bankDetails/{id}/customerDetails")
        public ResponseEntity<Collection<Customer>> getAllCustomerDetails(@PathVariable String id) {
           List customerDetailsRepo = customerService.getAllCustomerDetails(id);
           return new ResponseEntity<>(customerDetailsRepo, HttpStatus.OK);
        }




        /* Method to get a particular customer data
         * in postman:
         * GET: http://localhost:8080/bankDetails/102/customerDetails/1001
         * Response:
         * {
                "id": "1001",
                "customerName": "Mr Mahesh",
                "mobile": "9912345678",
                "address": "Madhapur, Hyderabad",
                "bank": {
                    "id": "102",
                    "bankName": "ICICI",
                    "branch": "Kondapur Branch",
                    "ifscCode": "ICIC00123",
                    "address": "Kondapur, Hyderabad"
                }
            }
         * */
        @RequestMapping(value="/bankDetails/{bankId}/customerDetails/{id}")
        public ResponseEntity<Customer> getCustomer(@PathVariable String id){
              Optional<Customer> customer = customerService.getCustomer(id);
              return new ResponseEntity(customer, HttpStatus.OK);
         }


        /* Method to add a new customer data
         * in postman:
         * Post: http://localhost:8080/bankDetails/102/customerDetails
         * Body:
         * {
                "id": "1002",
                "customerName": "Mr Sathvik",
                "mobile": "987634832",
                "address":  "Kothaguda, Hyderabad"
            }
         * Headers:
         *  Key: Content-Type, Value: application/json
         * returns Customer Added Successfully
         *
         * If we run GET request now we will get response newly added customer along with previous customer details
         * */
            @RequestMapping(method= RequestMethod.POST, value="/bankDetails/{bankId}/customerDetails")
            public ResponseEntity<String> addCustomer(@RequestBody Customer customer, @PathVariable String bankId){
                    customer.setBank(new Bank(bankId, "", "" ,"" ,""));
                    customerService.addCustomer(customer);
                    return new ResponseEntity<>("Customer Added Successfully", HttpStatus.OK);
        }

        /* Method to update a particular customer details
         * in postman:
         * PUT: http://localhost:8080/bankDetails/102/customerDetails/1001
         * Body:
         * {
                "id": "1001",
                "customerName": "Mr Mahesh",
                "mobile": "9912345678",
                "address":  "Hitech City, Madhapur, Hyderabad"
            }
         * Headers:
         *  Key: Content-Type, Value: application/json
         * returns Customer Updated Successfully
         *
         * If we run GET request now we will get response updated customer details along with existing customer details.
         * */
        @RequestMapping(method= RequestMethod.PUT, value="/bankDetails/{bankId}/customerDetails/{id}")
        public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable String bankId,  @PathVariable String id ){
            customer.setBank(new Bank(bankId, "", "" ,"" ,""));
            customerService.updateCustomer(customer);
            return new ResponseEntity<>("Customer Updated Successfully", HttpStatus.OK);
         }

        /* Method to delete a particular bank details
         * in postman:
         * DELETE: http://localhost:8080/bankDetails/102/customerDetails/1002

         * returns Customer Deleted Successfully
         *
         * If we run GET request now we will get response only with existing customer details.
         * */
        @RequestMapping(method= RequestMethod.DELETE, value="/bankDetails/{bankId}/customerDetails/{id}")
        public ResponseEntity<String> deleteCustomer(@PathVariable String id ){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
    }

}
