package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class routine_links extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_links);
    }

    public void night(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=pwuFbihJkoI"));
        startActivity(intent);
    }

    public void hair(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=z6zyd6zAjX4"));
        startActivity(intent);
    }

    public void morning(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=Mn9c68dYfWE"));
        startActivity(intent);
    }

    public void summer(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=avfIXNeKvwM"));
        startActivity(intent);
    }

    public void tips(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=bWhSXWLBdJ0"));
        startActivity(intent);
    }

    public void diet(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=95tL5XEM2J4"));
        startActivity(intent);
    }
}
