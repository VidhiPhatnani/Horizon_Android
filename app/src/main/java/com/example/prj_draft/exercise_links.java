package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class exercise_links extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_links);
    }

    public void cardio(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/fUJjsUn9bCo"));
        startActivity(intent);
    }

    public void high_intensity(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/zr08J6wB53Y"));
        startActivity(intent);
    }

    public void morning(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/diPRDW6CxWM"));
        startActivity(intent);
    }

    public void lose_fat_workout(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/PtdOi8Y3oRQ"));
        startActivity(intent);
    }

    public void yoga(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=Nnd5Slo02us"));
        startActivity(intent);
    }

    public void ab(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=AnYl6Nk9GOA"));
        startActivity(intent);
    }
}