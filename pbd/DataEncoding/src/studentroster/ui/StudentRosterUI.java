
package studentroster.ui;

import studentroster.dao.StudentRoster;
import studentroster.dto.Student;
import java.io.IOException;


public class StudentRosterUI {

    
    public static void main(String[] args) {
        
        
        StudentRoster roster= new StudentRoster();
        
        Student a = new Student("0001");
        a.setFirstName("Joe");
        a.setLastName("Smith");
        a.setCohort("Java August 2014");
        
        Student b = new Student("0002");
        b.setFirstName("Sally");
        b.setLastName("Jones");
        b.setCohort("Java Sept 2013");
        
        roster.addStudent(a.getStudentID(), a);
        roster.addStudent(b.getStudentID(), b);
        
        
        try{
        roster.writeRoster();
        } catch (IOException ioe) {
            System.out.println("Error writing to roster file: " + ioe.getMessage());
        }
        
        
        
        
    }
    
}
