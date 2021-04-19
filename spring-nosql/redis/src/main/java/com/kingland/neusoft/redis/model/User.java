package com.kingland.neusoft.redis.model;

import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public Long age;
    public String name;
    public String emailAddress;
    public String idNo;

    public User() {
    }

    public User(int id, Long age, String name,
                String emailAddress, String idNo) {
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
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
