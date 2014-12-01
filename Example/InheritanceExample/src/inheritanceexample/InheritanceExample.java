
package inheritanceexample;


public class InheritanceExample {

    
    public static void main(String[] args) {
       
//        Employee emp=new Employee();
//        emp.setFirstName("Joe");
//        emp.setLastName("Smith");
//        emp.doWork();
//       emp.createObjectives();
       
       
Employee emp2=new Manager();  //we CAN do this //construct new manager object, point to it with employee reference
emp2.setFirstName("John");    
emp2.setLastName("Doe"); 

//Manager mgr=new Employee();  //but can't do this because manager is broader than employee

emp2.doWork();  
emp2.createObjectives();  //eventhough we refer with employee reference, the thing is a manager.  Always calls the one closest to you
                          //treating manager as an employee
                          //can always go narrower, but not broader 
                          //all managers are employees, but not all amployees are managers



        
    }
    
}
