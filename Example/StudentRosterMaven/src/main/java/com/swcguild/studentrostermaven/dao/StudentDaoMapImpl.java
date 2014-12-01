
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import com.swcguild.studentrostermaven.logging.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StudentDaoMapImpl implements StudentDao{
    
    //key is studentID (string), value is student
    private Map<String, Student> studentMap=new HashMap<>();
    private Logger logger;
    
    //allow studentdaomapimpl to accept logger and inject it 
    public StudentDaoMapImpl(Logger logger){
    this.logger=logger;
    }
    
    

    @Override
    public void addStudent(Student student) {
       studentMap.put(student.getStudentID(), student);
       logger.logIt("Student Added: " + student.toString());
    }

    @Override
    public Student getStudentById(String id) {
        
        return studentMap.get(id);
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
      
     return studentMap.values().stream()
             .filter(s->s.getLastName().equalsIgnoreCase(lastName))
             .collect(Collectors.toList());

    }

    @Override
    public void removeStudent(String id) {
        studentMap.remove(id);
        logger.logIt("ID of student removed: " + id );
    }

    @Override
    public void updateStudent(Student student) {
        
        studentMap.put(student.getStudentID(), student);
        
    }
    
}
