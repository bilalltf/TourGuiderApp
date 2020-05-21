package com.example.tourguiderapp.model;

import java.io.Serializable;

public class TouristLogin implements Serializable {
    private String email;
    private String password;

    public TouristLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
