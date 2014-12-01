
package fileiohomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class LetterRevisited {

    
    public static void main(String[] args) throws Exception {
       
        PrintWriter myPW= new PrintWriter(new FileWriter("outputx.txt"));
        
        myPW.println("This is a lazy letter to myself");
        myPW.flush();
        myPW.close();
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("outputx.txt")));
    
        while (sc.hasNextLine()) {
        
        String currentLine= sc.nextLine();
        
            System.out.println(currentLine);
    }
    
    }
}