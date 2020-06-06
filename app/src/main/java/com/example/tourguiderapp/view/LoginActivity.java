package com.example.tourguiderapp.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.tourguiderapp.R;
import com.example.tourguiderapp.controller.ControlLogin;


public class LoginActivity extends AppCompatActivity {
    private ControlLogin controlLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private SwitchCompat switchCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    editTextEmail.setHint("");
                else
                    editTextEmail.setHint(R.string.email_hint);
            }
        });
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    editTextPassword.setHint("");
                else
                    editTextPassword.setHint(R.string.password_hint);
            }
        });
    }

    /**
     * initialization of the links between the graphic components and the properties
     */
    private void init() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        switchCompat = findViewById(R.id.rememberMe);
        editTextEmail.setHint(R.string.email_hint);
        editTextPassword.setHint(R.string.password_hint);


        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("switchCompat", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }else if(!switchCompat.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("switchCompat",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.controlLogin = ControlLogin.getInstance(this);
        listenBackChoose();
        listenLogin();
        recoverProfile();
    }

    /**
     * listen to the click on the ImageButton to return to the choose page
     */
    private void listenBackChoose(){
        (findViewById(R.id.btnBackLogin)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, ChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }


    /**
     * listen to the click on login
     */
    private void listenLogin(){
        (findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v){
                String email=null;
                String password=null;
                // Data recovery
                try {
                    email = editTextEmail.getText().toString();
                    password = editTextPassword.getText().toString();
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                }
                // Data control
                if(email == null || password == null|| email.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this,"Invalid Input",Toast.LENGTH_SHORT).show();
                }
                else{
                    // You must verify that the password is true here
                    showResult(email,password);
                }
            }
        });
    }

    // function completes the previous function to listen to the click login
    private void showResult(String email, String password){
        this.controlLogin.createTouristLogin(email,password,this);
        Toast.makeText(LoginActivity.this,"Correct entry",Toast.LENGTH_SHORT).show();
        Toast.makeText(LoginActivity.this,"Loading...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, CitiesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * recover data already saved
     */
    public void recoverProfile(){
        if(controlLogin.getEmailLogin() != null){
            editTextEmail.setText(controlLogin.getEmailLogin());
            editTextPassword.setText(controlLogin.getPasswordLogin());
            //((Button)findViewById(R.id.btnLogin)).performClick();
        }
    }


    public void clickSingUp(View v){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    // listen to the click on forgot password
    public void viewForgotPassword(View v){
        Intent intent= new Intent(LoginActivity.this,ForgotPasswordActivity.class);
        startActivity(intent);
    }

}