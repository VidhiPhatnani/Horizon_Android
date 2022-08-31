package com.example.prj_draft;

import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Timestamp;

public class journal extends AppCompatActivity {

    Button save,back,viewall;
    SQLiteDatabase db;
    EditText p1,p2,p3,p4,p5,p6;
    String email;
    DBJHandler DBJ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        DBJ = new DBJHandler(this);
        Intent i = getIntent();
        email = i.getStringExtra("emailkey");

        //db = openOrCreateDatabase("login", Context.MODE_PRIVATE,null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS journal(email TEXT references users,p1 TEXT,p2 TEXT,p3 TEXT,p4 TEXT,p5 TEXT,p6 TEXT)");

        save = findViewById(R.id.save);
        back = findViewById(R.id.back);
        viewall = findViewById(R.id.viewall);
        p1 =(EditText) findViewById(R.id.p1);
        p2 = (EditText)findViewById(R.id.p2);
        p3 = (EditText)findViewById(R.id.p3);
        p4 = (EditText)findViewById(R.id.p4);
        p5 = (EditText)findViewById(R.id.p5);
        p6 = (EditText)findViewById(R.id.p6);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(journal.this,HomeActivity.class);
                intent.putExtra("emailkey",email);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1.getText().toString().trim().length() == 0 || p2.getText().toString().trim().length() == 0 || p3.getText().toString().trim().length() == 0 ||
                        p4.getText().toString().trim().length() == 0 ||p5.getText().toString().trim().length() == 0 ||p6.getText().toString().trim().length() == 0){
                    Toast.makeText(journal.this, "All fields Required", Toast.LENGTH_SHORT).show();
                    return;
                }
                //db.execSQL("INSERT INTO journal('"+email+"','"+p1.getText()+"','"+p2.getText()+"','"+p3.getText()+"','"+p4.getText()+"','"+p5.getText()+"','"+p6.getText()+"')");
                Boolean insert = DBJ.insertData(email.toString(),p1.getText().toString(),p2.getText().toString(),p3.getText().toString(),p4.getText().toString(),p5.getText().toString(),p6.getText().toString());
                if(insert == TRUE)
                {
                    Toast.makeText(journal.this, "Success Record Added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(journal.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Cursor c=db.rawQuery("SELECT * FROM  journal WHERE email=? and t=?",new String[] { email },null);
//               if(c.moveToFirst())
//               {
//                   p1.setText(c.getString(1));
//                   p2.setText(c.getString(2));
//                   p3.setText(c.getString(3));
//                   p4.setText(c.getString(4));
//                   p5.setText(c.getString(5));
//                   p6.setText(c.getString(6));
//               }
//               else
//               {
//                   Toast.makeText(journal.this, "No Journal Entry", Toast.LENGTH_SHORT).show();
//               }
                Cursor c = DBJ.getData(email);

                if(c.moveToFirst())
                {
                    p1.setText(c.getString(1));
                    p2.setText(c.getString(2));
                    p3.setText(c.getString(3));
                    p4.setText(c.getString(4));
                    p5.setText(c.getString(5));
                    p6.setText(c.getString(6));
                }
                else
                {
                    Toast.makeText(journal.this,"No Journal Entry", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}