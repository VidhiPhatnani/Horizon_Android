package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class meditate_links extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate_links);
    }

    public void daily(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=j7d5Plai03g"));
        startActivity(intent);
    }

    public void anxiety(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=O-6f5wQXSu8"));
        startActivity(intent);
    }

    public void sleep(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=aEqlQvczMJQ"));
        startActivity(intent);
    }

    public void stress(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=z6X5oEIg6Ak"));
        startActivity(intent);
    }

    public void anger(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/fUJjsUn9bCo"));
        startActivity(intent);
    }

    public void depression(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=xRxT9cOKiM8"));
        startActivity(intent);
    }
}