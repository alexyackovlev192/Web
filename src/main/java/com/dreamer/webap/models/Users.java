package com.dreamer.webap.models;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer User_ID;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String full_Name;

    public Integer getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }
}

