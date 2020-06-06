package com.example.tourguiderapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tourguiderapp.R;
import com.example.tourguiderapp.controller.ControlRegister;


public class RegisterActivity extends AppCompatActivity {
    // properties
    EditText txtUserName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfirmPassword;
    Button btnRegister;

    private ControlRegister controlRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        txtUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txtUserName.setHint("");
                else
                    txtUserName.setHint(R.string.hint_name);
            }
        });
        txtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txtEmail.setHint("");
                else
                    txtEmail.setHint(R.string.email_hint);
            }
        });
        txtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txtPassword.setHint("");
                else
                    txtPassword.setHint(R.string.password_hint);
            }
        });
        txtConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txtConfirmPassword.setHint("");
                else
                    txtConfirmPassword.setHint(R.string.confirm_password_hint);
            }
        });

    }


    /**
     * initialization of connection with graphic objects
     */
    private void init() {

        //references to button and other controls on the layout

        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        this.controlRegister = ControlRegister.getInstance(this);
        txtUserName.setHint(R.string.hint_name);
        txtPassword.setHint(R.string.password_hint);
        txtEmail.setHint(R.string.email_hint);
        txtConfirmPassword.setHint(R.string.confirm_password_hint);

        listenRegister();
        listenBackChooseRegister();

    }

    /**
     * Listen to event on Register button
     */

    private void listenRegister(){
        btnRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String userName=null;
                String email=null;
                String password=null;
                String confirmPassword=null;

                // data recovery

                try {
                    userName = txtUserName.getText().toString();
                    email = txtEmail.getText().toString();
                    password = txtPassword.getText().toString();
                    confirmPassword = txtConfirmPassword.getText().toString();
                }catch (Exception e){
                    Toast.makeText(RegisterActivity.this,"",Toast.LENGTH_SHORT).show();
                }

                // data control

                if(userName==null||email==null||password==null||confirmPassword==null||userName.equals("")||
                        email.equals("")||password.equals("")||confirmPassword.equals("")){
                    Toast.makeText(RegisterActivity.this,"Invalid Input",Toast.LENGTH_SHORT).show();
                }
                else{
                    showResult(userName,email,password,confirmPassword);
                }
            }
        });

    }
    private void showResult(String userName, String email, String password, String confirmPassword){
        this.controlRegister.createProfileRegister(userName,email,password,confirmPassword);

        Toast.makeText(RegisterActivity.this,"Welcome " + userName + " to Tour Guider",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegisterActivity.this, CitiesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    private void listenBackChooseRegister(){
        (findViewById(R.id.btnBackRegister)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(RegisterActivity.this, ChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    public void viewLoginClick(View v){
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}

