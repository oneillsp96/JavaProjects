
package fileiohomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class SimpleFileInput {
    
    public static void main(String[] args) throws Exception {
        
        
        
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("SeanInput")));
    
        while (sc.hasNextLine()) {
        
        String currentLine= sc.nextLine();
        
            System.out.println(currentLine);
        
        
    }

    }
}