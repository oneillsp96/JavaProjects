
package arrayshomework;

import java.util.Random;
import java.util.Scanner;


public class FindingTheLargestValueInAnArray {
    
public static void main(String[] args) {

        int counter=0;
        int[] array1 = new int[10];

        System.out.println("Array Values: \n");

        for (int i = 0; i < array1.length; i++) {

            Random rGen = new Random();

            array1[i] = rGen.nextInt(100) + 1;

            System.out.print(array1[i] + " ");

        }

        int max=0;
        
        for (int i = 0; i <array1.length; i++) {
            
            if (array1[i]>array1[0]) {
            
            max=array1[i];
            }
        
    }
        System.out.println("\nMaximum Value: " + max);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
//        
//        for (int i=0; i<array1.length; i++) {
//        int slot= i;
//        
//        if (counter>0 && userChoice==array1[i]) {
//            
//            System.out.println(userChoice + " is in the array at slot " + slot);
//               }
//        
//        else if (counter<1){
//            System.out.println(userChoice + " is not in the array");   
//            return;
//        }
//
//}

    



    }

}
