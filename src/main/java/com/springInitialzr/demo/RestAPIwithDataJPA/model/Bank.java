package com.springInitialzr.demo.RestAPIwithDataJPA.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Bank {

    @Id
    private String id;
    private String bankName;
    private String branch;
    private String ifscCode;
    private String address;

    public Bank() {

    }

    public Bank(String id, String bankName, String branch, String ifscCode, String address) {
        super();
        this.id = id;
        this.bankName = bankName;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return  getId().equals(bank.getId()) &&
                getBankName().equals(bank.getBankName()) &&
                getBranch().equals(bank.getBranch()) &&
                getIfscCode().equals(bank.getIfscCode()) &&
                Objects.equals(getAddress(), bank.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBankName(), getBranch(), getIfscCode(), getAddress());
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
