package com.emranhss.restuarent.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
<<<<<<< Updated upstream
@Table(name = "bookTable")
=======
@Table
>>>>>>> Stashed changes
public class BookTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Date date;
    private int time;
    private String guest;
    private String massage;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;


    public BookTable() {
    }


    public BookTable(Long id, String name, String email, String phone, Date date, int time, String guest, String massage, Customer customer) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.guest = guest;
        this.massage = massage;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
