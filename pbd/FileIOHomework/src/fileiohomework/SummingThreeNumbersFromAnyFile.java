// what is this error from?





package fileiohomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class SummingThreeNumbersFromAnyFile {
    
    
    
    
 public static void main(String[] args) throws Exception {

 
        

 // read
     
     System.out.println("What file would you like to read?");
     
     Scanner sc=new Scanner(System.in);
     String fileChosen =(sc.nextLine());
     
     
        Scanner input = new Scanner(new BufferedReader(new FileReader(fileChosen)));

        while (input.hasNextLine()) {

            
            int a=Integer.parseInt(input.nextLine());
            int b=Integer.parseInt(input.nextLine());
            int c=Integer.parseInt(input.nextLine());        
            int sum= a+b+c;        
            

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);

            System.out.println("sum: " + sum);
        }

    }

}
