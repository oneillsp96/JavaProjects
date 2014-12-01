//this program writes to a file in the working directory and then reads it back into the console


package fileioexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class FileIOExample {

    public static void main(String[] args) throws Exception {

        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        out.println("This is line 1");
        out.println("This is line 2");
        out.flush();
        out.close();

        Scanner sc = new Scanner(new BufferedReader(new FileReader("output.txt")));
    
        while (sc.hasNextLine()) {
        
        String currentLine= sc.nextLine();
        
            System.out.println(currentLine);
        
        
        }
    
    }

}
