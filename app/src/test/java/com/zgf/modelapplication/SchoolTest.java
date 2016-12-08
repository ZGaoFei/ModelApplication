package com.zgf.modelapplication;

import com.zgf.modelapplication.mock.School;
import com.zgf.modelapplication.mock.Student;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zgf on 2016/12/8.
 */

public class SchoolTest {
    private static School school;
    private static Student xiaoming;
    private static Student xiaowang;

    @BeforeClass
    public static void setUp() {
        school = mock(School.class);

        xiaoming = mock(Student.class);
        xiaowang = mock(Student.class);
        when(xiaoming.getName()).thenReturn("xiaoming");
        when(xiaoming.getAge()).thenReturn(18);
        when(xiaoming.getSchoolName()).thenReturn("qinghua");

        when(xiaowang.getName()).thenReturn("xiaowang");
        when(xiaowang.getAge()).thenReturn(20);
        when(xiaowang.getSchoolName()).thenReturn("beida");

        Student student1 = new Student();
        student1.setSchoolName("qinghua");
        Student student2 = new Student();
        student2.setSchoolName("beida");

        when(school.getStudentSchool()).thenReturn(student1.getSchoolName());
    }

    @Test
    @Ignore
    public void testStudent() throws Exception {
        String name = xiaoming.getName();
        assertEquals(name, "xiaoming");
    }

    @Test
    @Ignore
    public void testSchool() throws Exception {
        String schoolName = school.getStudentSchool();
        assertEquals(schoolName, "qinghua");
    }

    @Test
    @Ignore
    public void testSchool2() throws Exception {
        // 判断在school类中的student的setName()方法是否调用一次
        Student mock = mock(Student.class);
        School school = new School();

        school.setStudent(mock);

        school.setStudentName("xiaoming"); // 调用一次
        verify(mock).setName("xiaoming"); // 判断是否被调用一次
    }
}
