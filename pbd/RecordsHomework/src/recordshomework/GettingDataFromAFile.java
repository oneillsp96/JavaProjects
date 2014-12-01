
package recordshomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class GettingDataFromAFile {
    
    
    public static void main(String[] args) throws Exception {
        
        //takes name of file, stores it in sc
        System.out.println("Please enter the name of the file");
        Scanner sc= new Scanner(System.in);
        
        //reads from dogs.txt
        Scanner input = new Scanner(new BufferedReader(new FileReader(sc)));
        
        while (input.hasNextLine()){
        
        
        String a=(input.nextLine());
        String b=(input.nextLine());
        String c=(input.nextLine());
        String d=(input.nextLine());
        String e=(input.nextLine());
        String f=(input.nextLine());
        
            System.out.println(a+b);
        
        }
        
        
        
        
        
        
    }
}
