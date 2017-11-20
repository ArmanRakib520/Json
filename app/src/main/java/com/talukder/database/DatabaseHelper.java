package com.talukder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by masum on 4/20/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="student";
    private static final int DATABASE_VERSION=1;
    private static final String STUDENT_TABLE="student_table";
    private static final String ID_FIELD="_id";
    private static final String NAME_FIELD="name";
    private static final String EMAIL_FIELD="email";
    private static final String PHONE_FIELD="phone";

    private static final String STUDENT_TABLE_SQL="CREATE TABLE " +STUDENT_TABLE +"" +
            " ("+ ID_FIELD+" INTEGER PRIMARY KEY, "+NAME_FIELD+" TEXT, "+EMAIL_FIELD+" TEXT, "+PHONE_FIELD+" TEXT)";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STUDENT_TABLE_SQL);
        Log.e("TABLE CREATED", STUDENT_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long insertStudent(Student student){


        ContentValues values=new ContentValues();
        SQLiteDatabase db=this.getWritableDatabase();

        values.put(NAME_FIELD,student.getsName());
        values.put(EMAIL_FIELD,student.getsEmail());
        values.put(PHONE_FIELD,student.getsPhone());

        long inserted=db.insert(STUDENT_TABLE,null,values);

        db.close();
        return inserted;
    }


    public ArrayList<Student> studentArrayList(){

        ArrayList<Student> allStudents=new ArrayList<Student>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query(STUDENT_TABLE,null,null,null,null,null,null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();

            for (int i=0;i<cursor.getCount();i++){
              int id=  cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String name=cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String email=cursor.getString(cursor.getColumnIndex(EMAIL_FIELD));
                String phone=cursor.getString(cursor.getColumnIndex(PHONE_FIELD));

                Student s=new Student(id,name,email,phone);
                allStudents.add(s);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return allStudents;
    }
}
