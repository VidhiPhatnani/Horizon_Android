package com.example.prj_draft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,"login.db",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table users(email TEXT primary key,password TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email",email);
        values.put("password",password);
        long result = db.insert("users",null,values);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?",new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
