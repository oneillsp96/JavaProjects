
package com.swcguild.studentrostermaven.controller;

import com.swcguild.studentrostermaven.dao.StudentDao;
import com.swcguild.studentrostermaven.domain.Student;
import com.swcguild.studentrostermaven.ui.IO;
import java.util.ArrayList;
import java.util.List;


public class StudentController {
    StudentDao dao;
    IO io;
    
    //injection point - inject from io interface
    //here we injected one bean into another....io into temp controller
    //when 'get bean' happens, studentcontroller object is constructed (before it was "new" keyword)
    
    public StudentController (IO io, StudentDao dao){
    this.io=io;
    this.dao=dao;
    }
    
    
    public void run(){
    String menuChoice="";
    
    do{ 
        menuChoice=displayMenu();
        
        switch (menuChoice){
            case "1": addStudent();
                break;
            case "2": getStudentByID();
                break;
            case "3": getStudentByLastName();
                break;
            case "4": removeStudent();
                break;
            case "5": updateStudent();
                break;
            case "Q":
            case "q": 
                io.print("Thank you, goodbye");
                break;
            default: 
                io.print("invalid input-  try again");
           
    }
     
    } while(!menuChoice.equalsIgnoreCase("Q"));
        
   
    }

    private String displayMenu() {
        return io.readString("=============================\n" + 
                             "1. Add Student\n" +
                             "2. Get Student by ID\n" + 
                             "3. Get Students by Last Name\n" +
                             "4. Remove Student\n" +
                             "5. Update Student\n" + 
                             "6.  Save \n" +
                             "Q = Quit"  );
        
        
                
    }

    private void addStudent() {
     Student temp=new Student();
    String firstName=io.readString("Enter student first name");
    temp.setFirstName(firstName);
    String lastName=io.readString("Enter student last name");
    temp.setLastName(lastName);
    String studentID=io.readString("Enter student ID");
    temp.setStudentID(studentID);
    dao.addStudent(temp);         //call addStudent method from impl (dao is bean id)
    io.print("student added");
    
        
    }

    private void getStudentByID() {
       
        Student temp=dao.getStudentById(io.readString("Enter the student ID to retrieve"));
        if (temp!=null){        
        io.print(temp.toString());
        }
        else {
        io.print("no student found with that ID");
        }
        
    }

    private void getStudentByLastName() {
     List <Student> temp=dao.getStudentsByLastName(io.readString("Please enter the last name to search for"));
     
    
//     .forEach(student -> io.print(student.toString()));   --using lambda expression
     
      for (Student st: temp) {
     
        
        if (st!=null){        
        io.print(st.toString());
        }
        else {
        io.print("no student found with that ID");
        }
    }

    }
    
    
    private void removeStudent() {
        String studentToRemove=io.readString("Please enter the Student ID of student to remove");
        String confirm = io.readString("are you sure you want to remove this student? (Y/N)");
        
        if (studentToRemove!=null && confirm.equals("Y")) {
        dao.removeStudent(studentToRemove);
        io.print("student removed");
        }
        else{
                io.print("No student found with that ID");
                }
        
        
        
    }

    private void updateStudent() {
        Student temp=dao.getStudentById( io.readString("Enter student ID of the student whose info you would like to modify"));
       if (temp!=null){
       io.print("student found: ");
       io.print(temp.toString());
       temp.setFirstName(io.readString("Please enter the new first name"));
       temp.setLastName(io.readString("Please enter the new last name"));
       }
       else{
       io.print("that is not a valid ID");
       }
        
        
        
        
    }
    
}
