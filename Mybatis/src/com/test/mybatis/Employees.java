package com.test.mybatis;

import java.io.Serializable;

/**
 * @author: Linduse
 * @Date: 2021/3/2 - 15:59
 * @since: jdk 1.8
 */
//@Alias("emp")
public class Employees implements Serializable {
    private int id;
    private String lastName;
    private String gender;
    private String email;

    public Employees(int id, String lastName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employees(String lastName, String gender, String email) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employees() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
