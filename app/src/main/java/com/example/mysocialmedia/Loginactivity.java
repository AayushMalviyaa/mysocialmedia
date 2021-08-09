package com.example.mysocialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginactivity extends AppCompatActivity {
EditText username,password;
Button btnlogin,signupb;
DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        btnlogin=findViewById(R.id.btnsignin1);
        signupb=findViewById(R.id.signupb);
        db=new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            { String user=username.getText().toString();
            String pass=password.getText().toString();
            if(user.equals("")||pass.equals(""))
                Toast.makeText(Loginactivity.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
            else
            {
                boolean checkuserpass=db.checkusernamepassword1(user,pass);
                if(checkuserpass==true)
                {
                    Toast.makeText(Loginactivity.this,"login successfull",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    intent.putExtra("user",user);

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Loginactivity.this,"invalid credentials",Toast.LENGTH_SHORT).show();
                }
            }

            }
        });
        signupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Loginactivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}