

package arrayshomework;

import java.util.Random;


public class LocatingTheLargestValueInAnArray {
    
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
        
        
        
        
        
        
        for (int i=0; i<array1.length; i++) {
            
            if (max==array1[i]) {
            
                System.out.println(max + " is located at slot: " + i);
            }
        
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}