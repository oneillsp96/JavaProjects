
package fileiohomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SummingThreeNumbersFromAFile {
    
   public static void main(String[] args) throws Exception {

 
        

 // read
        Scanner sc = new Scanner(new BufferedReader(new FileReader("3nums.txt")));

        while (sc.hasNextLine()) {

            
            int a=Integer.parseInt(sc.nextLine());
            int b=Integer.parseInt(sc.nextLine());
            int c=Integer.parseInt(sc.nextLine());        
            int sum= a+b+c;        
            

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);

            System.out.println("sum: " + sum);
        }

    }

}