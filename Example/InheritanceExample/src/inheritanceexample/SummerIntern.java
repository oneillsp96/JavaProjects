
package inheritanceexample;


public class SummerIntern extends Employee{
//    private String firstName;
//    private String lastName;
//    private int employeeID;
//    private String department;
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getEmployeeID() {
//        return employeeID;
//    }
//
//    public void setEmployeeID(int employeeID) {
//        this.employeeID = employeeID;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
    @Override
    public void doWork(){
        System.out.println("Summer Intern doing work");

   }
//    
//    public void createObjective(){
//        System.out.println("Summer Intern creating objective");
//    }
    
//    public void requestPerformanceReview() {
//        System.out.println("Summer intern requested performance review");
//    }

    @Override
    public void createObjectives() {
        System.out.println("Summer intern creates objectives");
    }

}
