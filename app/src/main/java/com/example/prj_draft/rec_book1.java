package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rec_book1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_book1);

         Button bookButton;
         Button audioBooksButton;
         Button orderBooksButton;

        bookButton = (Button) findViewById(R.id.books);
        bookButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openBookGenre();
            }
        });

        audioBooksButton = (Button) findViewById(R.id.audiobooks);
        audioBooksButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openAudioBookGenre();
            }
        });

        orderBooksButton = findViewById(R.id.orderBooks);
        orderBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderBooks();
            }
        });
    }

    public void openBookGenre(){
        Intent intent = new Intent(this, rec_book4.class);
        startActivity(intent);
    }

    public void openAudioBookGenre(){
        Intent intent = new Intent(this, rec_book2.class);
        startActivity(intent);
    }

    public void openOrderBooks(){
        Intent intent = new Intent(this,rec_book3.class);
        startActivity(intent);
    }
}