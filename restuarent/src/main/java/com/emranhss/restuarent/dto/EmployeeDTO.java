package com.emranhss.restuarent.dto;

import com.emranhss.restuarent.entity.Employee;

public class EmployeeDTO {

    private Long Id;
    private String photo;
    private String name;
    private String salary;
    private String email;
    private String phone;
    private String gender;
    private String location;
    private String nid;

//    Constructor


    public EmployeeDTO(Employee employee) {
        Id = employee.getId();
        this.photo = employee.getPhoto();
        this.name = employee.getName();
        this.salary = employee.getSalary();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
        this.gender = employee.getGender();
        this.location = employee.getLocation();
        this.nid = employee.getNid();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
}

