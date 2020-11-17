package com.example.caching.model;

import org.apache.tomcat.jni.Address;

public class Student {

    private String studentId;

    private String firstName;

    private String lastName;

    public Student(String studentId, String firstName, String lastName, Adress adress) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    private Adress adress;


}
