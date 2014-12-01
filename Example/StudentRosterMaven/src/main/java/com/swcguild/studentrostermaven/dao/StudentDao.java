
package com.swcguild.studentrostermaven.dao;

import com.swcguild.studentrostermaven.domain.Student;
import java.util.List;

public interface StudentDao {
    
    public void addStudent (Student student);
    public Student getStudentById(String id);
    public List<Student> getStudentsByLastName (String lastName);
    public void removeStudent (String id);
    public void updateStudent(Student student);
    
    
}
