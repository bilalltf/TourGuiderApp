package com.example.tourguiderapp.controller;

import android.content.Context;
import android.util.Log;



import com.example.tourguiderapp.model.AccessLocal;
import com.example.tourguiderapp.model.ProfileRegister;



public final class ControlRegister {
    private static ControlRegister instance = null;
    private static AccessLocal accessLocal;




    private ControlRegister() {
        super();
    }

    public static ControlRegister getInstance(Context context){
        if(ControlRegister.instance == null){
            ControlRegister.instance = new ControlRegister();
            accessLocal = new AccessLocal(context);

        }
        return ControlRegister.instance;
    }



    public void createProfileRegister(String userName, String email, String password, String confirmPassword){
        // properties
        ProfileRegister profileRegister = new ProfileRegister(-1, userName, email, password, confirmPassword);
        boolean success = accessLocal.addProfile(profileRegister);


        Log.i("DATABASE","add database : success="+success);
    }


//    public String getNameUser(){
//        if(profileRegister == null){
//            return null;
//        }
//        else {
//            return profileRegister.getUserName();
//        }
//    }
//
//    public String getEmail(){
//        if(profileRegister == null){
//            return null;
//        }
//        else {
//            return profileRegister.getEmail();
//        }
//    }
//
//    public String getPassword(){
//        if(profileRegister == null){
//            return null;
//        }
//        else {
//            return profileRegister.getPassword();
//        }
//    }
//
//    public String getConfirmPassword(){
//        if(profileRegister == null){
//            return null;
//        }
//        else {
//            return profileRegister.getConfirmPassword();
//        }
//    }
}
