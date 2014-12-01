//refers to student class


package recordshomework;

import java.util.Scanner;
import sun.awt.X11.XConstants;


public class ALittleDatabaseShorter {
    
public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        Student[] studentsArray = {student1, student2, student3};
        
        for (int i=0; i<studentsArray.length; i++){
        
            System.out.println("Enter the name of student " + (1+i));
            studentsArray[i].name=sc.nextLine();
            
            System.out.println("Enter the grade of student " + (1+i));
            studentsArray[i].grade=Integer.parseInt(sc.nextLine());            
            
            System.out.println("Enter the gpa of student" + (1+i));
            studentsArray[i].gpa=Double.parseDouble(sc.nextLine());
                    
                    
        
        
        } 
        
        

        System.out.println("The names are: " + studentsArray[0].name + ", " + studentsArray[1].name + ", " + studentsArray[2].name);
        System.out.println("The grades are: " + studentsArray[0].grade + ", " + studentsArray[1].grade + ", " + studentsArray[2].grade);
        System.out.println("The GPA's are: " + studentsArray[0].gpa + " " + studentsArray[1].gpa + ", " + studentsArray[2].gpa);
        System.out.println("The average GPA is: " + (studentsArray[0].gpa + studentsArray[1].gpa + studentsArray[2].gpa) / 3);

    }

}

