package com.emranhss.restuarent.dto;

import com.emranhss.restuarent.entity.Employee;

public class EmployeeDTO {


    private Long id;
    private String photo;
    private String name;
    private String salary;
    private String email;
    private String phone;
    private String gender;
    private String location;
    private String nid;
    private String designation;
    private Long userId; // just reference user ID

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.photo = employee.getPhoto();
        this.name = employee.getName();
        this.salary = employee.getSalary();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
        this.gender = employee.getGender();
        this.location = employee.getLocation();
        this.nid = employee.getNid();
        this.designation = employee.getDesignation();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

