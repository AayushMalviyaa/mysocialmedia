package com.example.mysocialmedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{public static final String DBNAME="Login.db";
    public DBHelper( Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
Mydb.execSQL("create Table users(username TEXT primary key,password TEXT,email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
Mydb.execSQL("drop Table if exists users");
    }
    public boolean insertData(String username,String password,String email)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        long result=Mydb.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        Cursor cursor=Mydb.rawQuery("Select * from users where username=?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
    public Boolean checkusernamepassword(String username,String password,String email)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        Cursor cursor=Mydb.rawQuery("Select * from users where username=? and password=? and email=?",new String[] {username,password,email});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
    public Boolean checkusernamepassword1(String username,String password)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        Cursor cursor=Mydb.rawQuery("Select * from users where username=? and password=? ",new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
}
