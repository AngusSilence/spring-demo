package com.kingland.neusoft.cloud.callerservice.model;


import javax.validation.constraints.*;

public class User {
    public int id;
    public int age;
    public String name;
    public String emailAddress;
    public String idNo;

    public User() {
    }

    public User(int id, @NotNull @Max(120) @Min(0) int age, @NotBlank @Size(max = 20, min = 5) String name,
                @Email String emailAddress, String idNo) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.emailAddress = emailAddress;
        this.idNo = idNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
