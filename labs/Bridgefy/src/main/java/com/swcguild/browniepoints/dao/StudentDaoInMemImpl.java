
package com.swcguild.browniepoints.dao;

import com.swcguild.browniepoints.model.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class StudentDaoInMemImpl implements StudentDao {
    
    private HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();

    private static int studentIdCounter = 0;

    @Override
    public void addStudent(Student student) {

        student.setStudentId(studentIdCounter);
               
        studentIdCounter++;
        studentMap.put(student.getStudentId(), student);
        

    }

    @Override
    public void removeStudent(int studentId) {

        studentMap.remove(studentId);
       

    }

    @Override
    public void updateStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
        

    }

    @Override
    public List<Student> getAllStudents() {

        Collection<Student> s = studentMap.values();
        return new ArrayList(s);

    }

    @Override
    public Student getStudentById(int studentId) {

        return studentMap.get(studentId);
    }
    
    
    
    @Override
    public List<Student> getStudentsBySide(String side){
    
       return studentMap.values().stream()
                .filter(s->s.getSide().equalsIgnoreCase(side))
               .collect(Collectors.toList());
                
    }
    
}
