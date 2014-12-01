package looppractice;

import java.util.Random;

public class DiceDoubles {

    public static void main(String[] args) {
        
        
        Random rGen= new Random();
        
        int rollOne= rGen.nextInt(6)+1;
        int rollTwo=rGen.nextInt(6) +1;
        
       
                
        
        
        
        while (rollOne!=rollTwo) {
            
            System.out.println("they're not equal yet....you rolled " + rollOne + " and " + rollTwo);
        
           rollOne=rGen.nextInt(6)+1;
           rollTwo=rGen.nextInt(6)+1;
           
        }
        
        System.out.println("You rolled doubles! (" +rollOne + ", " + rollTwo + ")");
       
        
        
    }

}
