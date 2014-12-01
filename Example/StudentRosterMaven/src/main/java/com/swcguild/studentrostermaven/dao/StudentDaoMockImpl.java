package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoMockImpl implements StudentDao {

    Student temp;
    List<Student> tempList;

    public StudentDaoMockImpl() {
        temp = new Student();
        temp.setFirstName("mock");
        temp.setLastName("Student");
        temp.setStudentID("00000");

        tempList = new ArrayList<>();
        tempList.add(temp);

    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Student getStudentById(String id) {
        return temp;
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return tempList;
    }

    @Override
    public void removeStudent(String id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

}
