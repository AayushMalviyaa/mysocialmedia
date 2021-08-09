package com.example.mysocialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText username, password ,repassword,email;
 Button signup ,signin;
 DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        signin=findViewById(R.id.btnsignin1);
        signup=findViewById(R.id.btnsignup);
        email=findViewById(R.id.EmailAddress);
        db=new DBHelper(this);

signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view)
    {
        String user=username.getText().toString();
        String pass=password.getText().toString();
        String repass=repassword.getText().toString();
        String e=email.getText().toString();
if(user.equals("")||pass.equals("")||repass.equals("")||e.equals(""))
{
    Toast.makeText(MainActivity.this,"please fill all fields properly",Toast.LENGTH_SHORT).show();

}
else
{ {
    if (pass.equals(repass)) {
        boolean checkuser = db.checkusername(user);
        if (checkuser == false) {
            boolean insert = db.insertData(user, pass,e);
            if (insert == true) {
                Toast.makeText(MainActivity.this, "user registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("user", user);

                startActivity(intent);
            } else
                Toast.makeText(MainActivity.this, "registration failed", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(MainActivity.this, "user already exist", Toast.LENGTH_SHORT).show();
    } else
        Toast.makeText(MainActivity.this, "passwords not matching", Toast.LENGTH_SHORT).show();

}


}

    }
});
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),Loginactivity.class);
                startActivity(intent);

            }
        });
    }
}