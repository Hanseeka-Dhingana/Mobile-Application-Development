package com.example.a03_intent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
 Button loginbtn;
 EditText emailtext, passtext;

 Intent intent;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        loginbtn = findViewById(R.id.login);
        emailtext = findViewById(R.id.email);
        passtext = findViewById(R.id.pass);


        emailtext.setText("abc@gmail.com");
        passtext.setText("1234");




        loginbtn.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){


               intent = new Intent(MainActivity.this, SecondActivity.class);

               // put data in the intent
               intent.putExtra("Email",  emailtext.getText().toString());
               intent.putExtra("Pass", passtext.getText().toString());

              //start second activity
              startActivity(intent);
           }
        });

    }
}