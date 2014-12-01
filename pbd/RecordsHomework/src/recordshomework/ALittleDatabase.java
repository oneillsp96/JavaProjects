//refers to Student class

package recordshomework;

import java.util.Scanner;

public class ALittleDatabase {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        Student[] studentsArray = {student1, student2, student3};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the 1st student's name: ");
        studentsArray[0].name = (sc.nextLine());
     // testing to make sure output is legit  System.out.println("You entered: " + student1.getName());

        System.out.print("Enter the 1st student's grade: ");
        studentsArray[0].grade = (Integer.parseInt(sc.nextLine()));
       // System.out.println("You entered: " + student1.getGrade());

        System.out.print("Enter the 1st student's GPA: ");
        studentsArray[0].gpa = (Double.parseDouble(sc.nextLine()));
       // System.out.println("You Entered: " + student1.getGpa());

        System.out.print("Enter the 2nd student's name: ");
        studentsArray[1].name = (sc.nextLine());

        System.out.print("Enter the 2nd student's grade: ");
        studentsArray[1].grade = (Integer.parseInt(sc.nextLine()));

        System.out.print("Enter the 2nd student's GPA: ");
        studentsArray[1].gpa = (Double.parseDouble(sc.nextLine()));

        System.out.print("Enter the 3rd student's name: ");
        studentsArray[2].name = (sc.nextLine());

        System.out.print("Enter the 3rd student's grade: ");
        studentsArray[2].grade = (Integer.parseInt(sc.nextLine()));

        System.out.print("Enter the 3rd student's GPA: ");
        studentsArray[2].gpa = (Double.parseDouble(sc.nextLine()));

        System.out.println("The names are: " + studentsArray[0].name + ", " + studentsArray[1].name + ", " + studentsArray[2].name);
        System.out.println("The grades are: " + studentsArray[0].grade + ", " + studentsArray[1].grade + ", " + studentsArray[2].grade);
        System.out.println("The GPA's are: " + studentsArray[0].gpa + " " + studentsArray[1].gpa + ", " + studentsArray[2].gpa);
        System.out.println("The average GPA is: " + (studentsArray[0].gpa + studentsArray[1].gpa + studentsArray[2].gpa) / 3);

    }

}
