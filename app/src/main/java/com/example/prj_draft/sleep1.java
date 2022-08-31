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

public class sleep1 extends AppCompatActivity {

    Button b1;
    RadioGroup rg;
    RadioButton rb;
    String q1checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep1);

        b1=findViewById(R.id.nextButton);
        //rg=(RadioGroup)findViewById(R.id.q1rg);
        rg=findViewById(R.id.q1rg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(sleep1.this,"Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent intent = new Intent(sleep1.this, sleep2.class);
                    rb=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                    q1checked = rb.getText().toString();
                    intent.putExtra("q1checked",q1checked);
                    startActivity(intent);
                }
            }
        });
    }

    public void redirect5(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/lFcSrYw-ARY"));
        startActivity(intent);
    }

    public void redirect2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/OeHLHNKQCXA"));
        startActivity(intent);
    }
}
