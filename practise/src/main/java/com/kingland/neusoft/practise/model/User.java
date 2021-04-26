package com.kingland.neusoft.practise.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User implements Serializable {

    private Integer id;
    @NotNull
    private String name;
    @Min(1)
    @Max(120)
    private Integer age;

    private static final long serialVersionUID = 1L;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}