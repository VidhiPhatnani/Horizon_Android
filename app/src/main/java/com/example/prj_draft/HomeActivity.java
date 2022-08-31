package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    ImageButton journal,breather,book,sleep,consult;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.home_bg);
        setContentView(R.layout.activity_home);

        journal = findViewById(R.id.journal);
        breather = findViewById(R.id.breather);
        book = findViewById(R.id.book);
        sleep = findViewById(R.id.sleep);
        consult = findViewById(R.id.consult);

        Intent i = getIntent();
        email = i.getStringExtra("emailkey");

        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,journal.class);
                intent.putExtra("emailkey",email);
                startActivity(intent);
            }
        });

        breather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this,breather1.class);
               startActivity(intent);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,rec_book1.class);
                startActivity(intent);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,sleep1.class);
                intent.putExtra("emailkey",email);
                startActivity(intent);
            }
        });

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this,consult.class);
               startActivity(intent);
            }
        });
    }
}