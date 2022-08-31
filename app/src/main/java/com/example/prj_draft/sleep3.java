package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class sleep3 extends AppCompatActivity {

    Button finish;
    RadioGroup rg;
    RadioButton rb;
    String q2checked;
    String q1checked;
    String q3checked;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep3);

        finish = findViewById(R.id.button);
        //rg=(RadioGroup)findViewById(R.id.q3rg);
        rg=findViewById(R.id.q3rg);
        Intent i = getIntent();
        q1checked = i.getStringExtra("q1checked");
        q2checked = i.getStringExtra("q2checked");

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rg.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(sleep3.this,"Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent intent = new Intent(sleep3.this, sleep_report.class);
                    rb=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                    q3checked = rb.getText().toString();

                    if(q1checked.trim().equals("8 to 9 hours"))
                    {
                        score = score + 10;
                    }
                    else if(q1checked.trim().equals("6 to 7 hours"))
                    {
                        score = score + 7;
                    }
                    else
                    {
                        score = score + 4;
                    }

                    if(q2checked.trim().equals("No"))
                    {
                        score = score + 10;
                    }
                    else if(q2checked.trim().equals("Sometimes"))
                    {
                        score = score + 7;
                    }
                    else
                    {
                        score = score + 4;
                    }

                    if(q3checked.trim().equals("Yes"))
                    {
                        score = score + 10;
                    }
                    else if(q3checked.trim().equals("Sometimes"))
                    {
                        score = score + 7;
                    }
                    else
                    {
                        score = score + 4;
                    }
                    intent.putExtra("score",score);
                    startActivity(intent);
                }
            }
        });

    }
    public void redirect3 (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/NDFeKOLDcfc"));
        startActivity(intent);
    }

    public void redirect6 (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/1GPsepFmNes"));
        startActivity(intent);
    }
}