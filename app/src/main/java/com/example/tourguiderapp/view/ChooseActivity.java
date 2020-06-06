package com.example.tourguiderapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tourguiderapp.R;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        listenLogin();
        listenRegister();
        /*
        SharedPreferences preferences = getSharedPreferences("switchCompat",MODE_PRIVATE);
        String checked = preferences.getString("remember","");
        if(checked.equals("true")){
            Intent intent = new Intent(ChooseActivity.this, CitiesActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else if(!checked.equals("false")){
            Toast.makeText(ChooseActivity.this, "Please Sing In.", Toast.LENGTH_SHORT).show();
        }
        */
    }

    /**
     * Listen to the click on the Login button
     */
    private void listenLogin(){
        (findViewById(R.id.btnLogin)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChooseActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * Listen to the click on the Register button
     */
    private void listenRegister(){
        (findViewById(R.id.btnRegister)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChooseActivity.this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * Listen to the click on the Skip button to go without Login or Register
     */
    public void clickSkip(View v){
        Intent intent = new Intent(ChooseActivity.this, CitiesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
