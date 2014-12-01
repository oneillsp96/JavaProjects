

package looppractice;

import java.util.Random;


public class DoWhileDice {
   
    public static void main(String[] args) {
   
        
        
        
        Random rGen= new Random();
        
        int rollOne= rGen.nextInt(6)+1;
        int rollTwo=rGen.nextInt(6) +1;
        
       
         do {
            
            System.out.println("they're not equal yet....you rolled " + rollOne + " and " + rollTwo);
        
           rollOne=rGen.nextInt(6)+1;
           rollTwo=rGen.nextInt(6)+1;
           
        }       
                
        
        while (rollOne!=rollTwo); 
        
        System.out.println("You rolled doubles! (" +rollOne + ", " + rollTwo + ")");
       
        
        
    }

}
