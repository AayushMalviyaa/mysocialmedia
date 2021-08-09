package com.example.mysocialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
TextView t;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String username=getIntent().getStringExtra("user");
        t=findViewById(R.id.wel);
        t.setText("WELCOME "+username);
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(HomeActivity.this,Loginactivity.class);
                startActivity(intent);
            }
        });
    }
}