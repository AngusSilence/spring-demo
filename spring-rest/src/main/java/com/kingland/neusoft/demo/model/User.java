package com.kingland.neusoft.demo.model;


import javax.validation.constraints.*;

public class User {
    @Min(1)
    public int id;
    @NotNull
    @Max(120)
    @Min(0)
    public int age;
    @NotBlank
    @Size(max = 20, min = 3)
    public String name;
    @Email
    public String emailAddress;
    @Pattern(regexp = "(^[1-9]\\d{5}(19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)")
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
