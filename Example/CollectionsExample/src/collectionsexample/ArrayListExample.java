package collectionsexample;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

    public static void main(String[] args) {

        //cannot put primitive types in ArrayList (int, double, etc.)
        //repeating <Integer> is not necessary in Java 8
        ArrayList<Integer> al = new ArrayList<Integer>();

        Integer a = new Integer(1); /// or, Integer a=1
        Integer b = 1;

        //adds a to ArrayList
        al.add(a);
        al.add(b);
        //arrayList and 'a' point to same place in memory?

        System.out.println(al.size());//display number of items in array list

        int c = al.get(0);

        System.out.println(c);

        ArrayList<Student> students = new ArrayList<>();

        Student st1 = new Student();
        st1.setFirstName("Joe");
        st1.setLastName("Smith");
        students.add(st1);

        Student st2 = students.get(0);
        System.out.println(st2.getFirstName());

        // Student st2= new Student();
        st2.setFirstName("Mark");

        System.out.println(st1.getFirstName());

        Student st3 = new Student();
        st3.setFirstName("Sally");
        st3.setLastName("Jones");

        Student st4 = new Student();
        st4.setFirstName("John");
        st4.setLastName("Doe");

        students.add(st3);
        students.add(st4);

        System.out.println("Number of students: " + students.size());

        //Iterator - visits every element in the collection- technique 1
        Iterator<Student> iter = students.iterator();

        while (iter.hasNext()) {
            Student currentStudent = iter.next();
            System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());

        }

        //enhanced for-loop does same job - technique 2
        //for each student object in ArrayList "students", put next sequential student into variable myStudent 
        for (Student myStudent : students) {

            System.out.println(myStudent.getFirstName() + " " + myStudent.getLastName());

        }

        //can use normal for-loop but it's tedious- technique 3
        for (int i = 0; i < students.size(); i++) {

            Student currentStudent = students.get(i);

            System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());

        }

    }
}
