
package arrayshomework;

import java.util.Random;
import java.util.Scanner;


public class HowManyTimes {
    
public static void main(String[] args) {

        int counter=0;
        int[] array1 = new int[10];

        System.out.println("Array Values: \n");

        for (int i = 0; i < array1.length; i++) {

            Random rGen = new Random();

            array1[i] = rGen.nextInt(50) + 1;

            System.out.print(array1[i] + " ");

        }

        Scanner sc = new Scanner(System.in);
    
        System.out.println();
        System.out.println("\nPlease enter an integer");
        int userChoice = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < array1.length; i++) {

            if (userChoice == array1[i]) {
                
                counter++;
 
            } 
            
        }

        
        System.out.println(userChoice + " is in the array " + counter + " times");
        
        
    }
}

