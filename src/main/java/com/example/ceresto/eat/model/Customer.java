package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.*;

@Entity
@Table
public class Customer extends Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String diet;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Long creditCardNumber;

    public Customer(RecordStatus status, Long customerId, String name, String surname, Integer age, String password, String address, String email, String diet, String phoneNumber, Long creditCardNumber) {
        super(RecordStatus.ACTIVE);
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.address = address;
        this.email = email;
        this.diet = diet;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
    }

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
