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

public class sleep2 extends AppCompatActivity {

    Button b1;
    RadioGroup rg;
    RadioButton rb;
    String q2checked;
    String q1checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep2);

        b1 =findViewById(R.id.button);
        //rg=(RadioGroup)findViewById(R.id.q2rg);
        rg=findViewById(R.id.q2rg);
        Intent i = getIntent();
        q1checked = i.getStringExtra("q1checked");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(sleep2.this,"Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent intent = new Intent(sleep2.this, sleep3.class);
                    rb=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                    q2checked = rb.getText().toString();
                    intent.putExtra("q2checked",q2checked);
                    intent.putExtra("q1checked",q1checked);
                    startActivity(intent);
                }
            }
        });
    }

    public void redirect4(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/2OEL4P1Rz04"));
        startActivity(intent);
    }

    public void redirect1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/3NycM9lYdRI"));
        startActivity(intent);
    }
}