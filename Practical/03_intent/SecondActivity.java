package com.example.a03_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
   Intent intent;

   TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        showData = findViewById(R.id.showdata);

        if(intent.hasExtra("Email") && intent.hasExtra("Pass")){
            showData.setText(intent.getStringExtra("Email"));
            showData.setText(intent.getStringExtra("pass"));
        }

    }
}