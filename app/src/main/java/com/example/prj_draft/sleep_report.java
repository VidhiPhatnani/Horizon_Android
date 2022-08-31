package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sleep_report extends AppCompatActivity {

    Integer score;
    TextView scoretext;
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_report);

        Intent i = getIntent();
        score = i.getIntExtra("score",0);

        backbtn = findViewById(R.id.backbtn);
        scoretext = findViewById(R.id.scoretext);

        scoretext.setText(score.toString());

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sleep_report.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}