
package arrayshomework;

import java.util.Random;

public class CopyingArrays {
    
    public static void main(String[] args) {
        
        Random rGen=new Random();
        
        int[]array1= new int[10];
       
       
       
        for (int i=0; i<(array1.length); i++) {
    
        array1[i]=rGen.nextInt(100)+1;
       
        
        
        //Prints array1 before making change to -7 at position 9
        
        System.out.print(array1[i] + " "); 
    
    }
       
    
    
    
    
        System.out.println();
      
        int[]array2=new int[10];
    
        for (int i=0; i<array2.length; i++) {
    
        array2[i]=array1[i];
        
    //prints array 2
        
        System.out.print(array2[i] + " ");
    
    
    }
    
        
        System.out.println();
        
        
        //change array1's position 9 to a -7
        array1[9]=-7;
        
        for (int i=0; i<array1.length; i++) {
        
            
            
        //prints array 1 after changing    
            System.out.print(array1[i] + " ");
            
        
        }
    
    
    }
       
    
}
