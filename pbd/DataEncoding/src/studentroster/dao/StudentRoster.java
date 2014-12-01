package studentroster.dao;

import studentroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentRoster {

    //stores 
    //  UI allows user to add/delete/modify students
    //create constant for roster file and constant for delimiter
    //make static because we only need copy
    //make it final (read only)
    //constants are all caps and underscored
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private HashMap<String, Student> students = new HashMap<String, Student>();

    //want to be able to add/remove/modify students
    //puts student into HashMap
    public Student addStudent(String studentID, Student student) {

        return students.put(studentID, student);

    }

    public Student removeStudent(String studentID) {

        return students.remove(studentID);

    }

    public Student getStudent(String studentID) {

        return students.get(studentID);

    }

    public String[] getAllStudentIDs() {

        Set<String> keySet = students.keySet();                    //create keyArray
        String[] keyArray = new String[keySet.size()];            //create string array to store key
        //turn keySet into array
        keyArray = keySet.toArray(keyArray);                        //ask keySet to turn into array using toArray method

        //could also use String[]keyArray=keySet.toArray(new String[0]);
        return keyArray;

    }

    
    
    
    
    
    //write to file
    public void writeRoster() throws IOException {
//named the printwriter out and set it up
        PrintWriter out = new PrintWriter(new FileWriter(ROSTER_FILE));

        String[] keys = this.getAllStudentIDs();

        for (int i = 0; i < keys.length; i++) {

            //get my next student
            Student currentStudent = this.getStudent(keys[i]);

            out.println(currentStudent.getStudentID() + DELIMITER + currentStudent.getFirstName() + DELIMITER + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());

            //force write
            out.flush();
        }

        out.close();

    }

    //read file 
    public void loadRoster() throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));

        //"bookkeeping"
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            //get the line and put it into current line
            currentLine = sc.nextLine();

            //tells it to split string on delimiter(:: in this case)
            currentTokens = currentLine.split(DELIMITER);

            Student currentStudent = new Student(currentTokens[0]);
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);

            students.put(currentStudent.getStudentID(), currentStudent);

        }
        sc.close();

    }

}
