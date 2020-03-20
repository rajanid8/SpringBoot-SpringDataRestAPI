package com.springInitialzr.demo.RestAPIwithDataJPA.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
import com.springInitialzr.demo.RestAPIwithDataJPA.model.Bank;

@Entity
public class Customer {

    @Id
    private String id;
    private String customerName;
    private String mobile;
    private String address;

    @ManyToOne
    private Bank bank;

    public Customer() {

    }

    public Customer(String id, String customerName, String mobile,  String address, String bankName) {
        super();
        this.id = id;
        this.customerName = customerName;
        this.mobile = mobile;
        this.address = address;
        this.bank = new Bank(bankName, "","" ,"", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Bank getBank() { return bank;    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerName().equals(customer.getCustomerName()) &&
                getMobile().equals(customer.getMobile()) &&
                Objects.equals(getAddress(), customer.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getMobile(), getAddress());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }*/
}
