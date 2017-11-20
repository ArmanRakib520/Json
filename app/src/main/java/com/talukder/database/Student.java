package com.talukder.database;

/**
 * Created by masum on 4/20/16.
 */
public class Student {
    private int s_id;
    private String sName;
    private String sEmail;
    private String sPhone;


    Student(){

    }


    Student(int s_id,String sName,String sEmail,String sPhone){
        this.s_id=s_id;
        this.sName=sName;
        this.sEmail=sEmail;
        this.sPhone=sPhone;

    }

    Student(String sName,String sEmail,String sPhone){

        this.sName=sName;
        this.sEmail=sEmail;
        this.sPhone=sPhone;
    }


    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", sName='" + sName + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sPhone='" + sPhone + '\'' +
                '}';
    }
}
