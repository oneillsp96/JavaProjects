
package com.swcguild.browniepoints.dao;

import com.swcguild.browniepoints.model.Student;
import java.util.List;


public interface StudentDao {
    
    public void addStudent(Student student);
    public void removeStudent(int studentId);
    public void updateStudent(Student student);
    public Student getStudentById(int studentId);
    
    
    public List<Student> getAllStudents();

    public List<Student> getStudentsBySide(String side);    //students can be on teacher's good side or bad side
    //    public List<Student> getStudentsByPoints();   --get all then sort in controller/impl
//    public void addPoints(Student student);    //students can gain or lose points -- use update method in controller
    
    
}
