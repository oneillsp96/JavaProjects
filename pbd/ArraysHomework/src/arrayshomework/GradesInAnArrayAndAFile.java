//need to learn fil I/O to finish this one

package arrayshomework;

import java.util.Random;
import java.util.Scanner;


public class GradesInAnArrayAndAFile {
    
    
    
    
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        
        System.out.println("Enter your name");
        String name=sc.nextLine();
        
        System.out.println("Enter the file name");
        String fileName=sc.nextLine();
        
        int[] gradesArray = new int[5];
        
        
        
        for (int i=0; i<gradesArray.length; i++){
            Random rGen= new Random();
            
            gradesArray[i]= rGen.nextInt(100)+1;
            
            System.out.println(gradesArray[i]);
        }
        
        
        
        
        System.out.println("Hello " + name);
        System.out.println("Here are your randomly chosen grades: \n");
        
        System.out.println("Grade 1: " + gradesArray[0]);
        System.out.println("Grade 2: " + gradesArray[1]);
        System.out.println("Grade 3: " + gradesArray[2]);
        System.out.println("Grade 4: " + gradesArray[3]);
        System.out.println("Grade 5: " + gradesArray[4]);
               
        
        
        
    }
    
    
    
}
