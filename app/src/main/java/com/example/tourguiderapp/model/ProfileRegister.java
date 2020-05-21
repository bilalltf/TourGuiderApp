package com.example.tourguiderapp.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class ProfileRegister implements Serializable {
    // properties
    private Integer user_id;
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;

    public ProfileRegister(Integer user_id, String userName, String email, String password, String confirmPassword) {
        this.user_id = user_id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }




    String getUserName() {
        return userName;
    }


    String getEmail() {
        return email;
    }


    String getPassword() {
        return password;
    }



    String getConfirmPassword() {
        return confirmPassword;
    }

    @NotNull
    @Override
    public String toString() {
        return "ProfileRegister{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
