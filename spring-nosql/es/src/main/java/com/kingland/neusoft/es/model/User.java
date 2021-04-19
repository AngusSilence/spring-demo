package com.kingland.neusoft.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName="persons")
public class User implements Serializable {
    @Id
    public int id;
    @Field(type = FieldType.Long)
    public Long age;
    @Field(type = FieldType.Text)
    public String name;
    @Field(type = FieldType.Text)
    public String emailAddress;
    @Field(type = FieldType.Text)
    public String idNo;
    @Field(type = FieldType.Text)
    public String description;

    public User() {
    }

    public User(int id, Long age, String name,
                String emailAddress, String idNo,String description) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.emailAddress = emailAddress;
        this.idNo = idNo;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
