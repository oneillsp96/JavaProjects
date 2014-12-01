package studentroster.dto;

import java.util.Objects;

public class Student {

    
    //we made student ID final, even though removing setter on the ID already makes it read-only
    
    private final String studentID;  //make ID read only
    private String firstName;
    private String lastName;
    private String cohort;
    
    
    //constructor
    
    public Student (String studentID){
    
    this.studentID=studentID;
    }
    
    
    

    public String getStudentID() {
        return studentID;
    }

//    public void setStudentID(String studentID) {
//        this.studentID = studentID;
//    }

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

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.studentID);
        hash = 47 * hash + Objects.hashCode(this.firstName);
        hash = 47 * hash + Objects.hashCode(this.lastName);
        hash = 47 * hash + Objects.hashCode(this.cohort);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } //is inoming object of the same class?
        if (getClass() != obj.getClass()) {
            return false;
        } //now we put incoming object into another object and check field by field
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.cohort, other.cohort)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
}
