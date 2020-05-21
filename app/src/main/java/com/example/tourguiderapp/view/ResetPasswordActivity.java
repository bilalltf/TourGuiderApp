package com.example.tourguiderapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tourguiderapp.R;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        listenBackLogin();
        listenDone();
    }

    private void listenBackLogin(){
        findViewById(R.id.btnBackLogin).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ResetPasswordActivity.this, ForgotPasswordActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    private void listenDone(){
        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ResetPasswordActivity.this, CitiesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
