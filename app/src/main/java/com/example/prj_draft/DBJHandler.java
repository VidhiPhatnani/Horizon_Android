package com.example.prj_draft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBJHandler extends SQLiteOpenHelper {
    public DBJHandler(Context context){
        super(context,"login.db",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table journal(email TEXT references users,p1 TEXT,p2 TEXT,p3 TEXT,p4 TEXT,p5 TEXT,p6 TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //db.execSQL("drop table if exists journal");
   }

    public Boolean insertData(String email, String p1,String p2,String p3,String p4,String p5,String p6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        Cursor cursor = db.rawQuery("select * from journal where email=?",new String[] {email});
        if(cursor.getCount() == 0) {
            values.put("email", email);
            values.put("p1", p1);
            values.put("p2", p2);
            values.put("p3", p3);
            values.put("p4", p4);
            values.put("p5", p5);
            values.put("p6", p6);
            long result = db.insert("journal", null, values);
            if (result == -1)
                return false;
            else
                return true;
        }
        else {
            boolean flag = updateData(email, p1, p2, p3, p4, p5, p6);
            return flag;
        }
    }

    public Boolean updateData(String email,String p1,String p2,String p3,String p4,String p5,String p6){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues values = new ContentValues();

        values.put("p1",p1);
        values.put("p2",p2);
        values.put("p3",p3);
        values.put("p4",p4);
        values.put("p5",p5);
        values.put("p6",p6);
        long result = db.update("journal",values,"email=?",new String[] {email});
        if(result==-1) return false;
        else
            return true;
    }

    public Cursor getData(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM journal where email=?",new String[] {email},null);
        return c;
    }
}
