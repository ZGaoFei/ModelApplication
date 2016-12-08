package com.zgf.modelapplication.mock;

import android.util.Log;

/**
 * Created by zgf on 2016/12/8.
 */

public class School {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentName() {
        return student.getName();
    }

    public int getStudentAge() {
        return student.getAge();
    }

    public String getStudentSchool() {
        return student.getSchoolName();
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void goSchool() {
        Log.e("======", student.getName() + "==age=" + student.getAge() + "==go school==" + student.getSchoolName());
    }
}
