package com.talukder.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText eName,ePhone,eEmail;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        dbHelper=new DatabaseHelper(this);

    }

    private void initialization() {

        eName= (EditText) findViewById(R.id.EditTextName);
        eEmail= (EditText) findViewById(R.id.EditTextEmail);
        ePhone= (EditText) findViewById(R.id.EditTextPhone);
    }


    public void save(View v){
        String name=eName.getText().toString();
        String email=eEmail.getText().toString();
        String phone=ePhone.getText().toString();
        Student student=new Student(name,email,phone);
        long insert =dbHelper.insertStudent(student);

        if(insert>=0){
            Toast.makeText(MainActivity.this, "Databased value inserted", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(MainActivity.this, "Databased insertoin failed", Toast.LENGTH_SHORT).show();



    }

    public void viewData(View v){
      ArrayList<Student > students = dbHelper.studentArrayList();
        if(students!= null && students.size()>0){
            for (Student s: students) {
                Toast.makeText(MainActivity.this, " value : "+s, Toast.LENGTH_SHORT).show();

            }
        }

    }
}
