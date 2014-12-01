package inheritanceexample;

public class Manager extends Employee {

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
    public void doWork() {
        System.out.println("Manager doing work");
    }
    @Override
    public void createObjectives() {
       // super.createObjectives(); //calls parent class's version of a method
        System.out.println("Manager created objectives");

    }

    public void hire() {
        System.out.println("Manager hired someone");
    }

    public void fire() {
        System.out.println("Manager fired someone");
    }

    public void givePerformanceReview() {
        System.out.println("Manager gave performance review");
    }

}
