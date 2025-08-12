package com.emranhss.restuarent.dto;

import com.emranhss.restuarent.entity.Customer;

import java.util.Date;

public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private Date dateOfBirth;
    private String photo;

    // Constructor
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.gender = customer.getGender();
        this.address = customer.getAddress();
        this.dateOfBirth = customer.getDateOfBirth();
        this.photo = customer.getPhoto();
    }
}
