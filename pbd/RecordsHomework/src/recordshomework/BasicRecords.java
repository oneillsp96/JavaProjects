//this file refers to class Student
//
//     !!!!!!!!!!!!!!!!!!!
//
package recordshomework;

import java.util.Scanner;

public class BasicRecords {

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
        student2.setName(sc.nextLine());

        System.out.print("Enter the 2nd student's grade: ");
        student2.setGrade(Integer.parseInt(sc.nextLine()));

        System.out.print("Enter the 2nd student's GPA: ");
        student2.setGpa(Double.parseDouble(sc.nextLine()));

        System.out.print("Enter the 3rd student's name: ");
        student3.setName(sc.nextLine());

        System.out.print("Enter the 3rd student's grade: ");
        student3.setGrade(Integer.parseInt(sc.nextLine()));

        System.out.print("Enter the 3rd student's GPA: ");
        student3.setGpa(Double.parseDouble(sc.nextLine()));

        System.out.println("The names are: " + student1.getName() + ", " + student2.getName() + ", " + student3.getName());
        System.out.println("The grades are: " + student1.getGrade() + ", " + student2.getGrade() + ", " + student3.getGrade());
        System.out.println("The GPA's are: " + student1.getGpa() + " " + student2.getGpa() + ", " + student3.getGpa());
        System.out.println("The average GPA is: " + (student1.getGpa() + student2.getGpa() + student3.getGpa()) / 3);

    }

}
