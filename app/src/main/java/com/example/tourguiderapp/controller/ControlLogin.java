package com.example.tourguiderapp.controller;

import android.content.Context;

import com.example.tourguiderapp.model.TouristLogin;
import com.example.tourguiderapp.tools.Serializer;

public final class ControlLogin {
    private static TouristLogin touristLogin;
    private static ControlLogin instance = null;
    private static String nomFicLogin = "saveLogin";

    private ControlLogin() {
        super();
    }
    public static ControlLogin getInstance(Context context){
        if(ControlLogin.instance == null){
            ControlLogin.instance = new ControlLogin();
            recoverSerialize(context);
        }
        return ControlLogin.instance;
    }


    public void createTouristLogin(String email, String password, Context context){
        touristLogin = new TouristLogin(email,password);

        Serializer.serialize(nomFicLogin,touristLogin,context);
    }


    public String getEmailLogin(){
        if(touristLogin == null){
            return null;
        }
        else {
            return touristLogin.getEmail();
        }
    }


    public String getPasswordLogin(){
        if(touristLogin == null){
            return null;
        }
        else {
            return touristLogin.getPassword();
        }
    }

    private static void recoverSerialize(Context context){
        touristLogin = (TouristLogin) Serializer.deSerialize(nomFicLogin,context);
    }
}
