package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText email_login, password_login;
    Button signin_login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        signin_login = findViewById(R.id.signin_login);
        DB = new DBHelper(this);

        signin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = email_login.getText().toString();
                String pass = password_login.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity2.this, "All fields required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("emailkey",user);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}