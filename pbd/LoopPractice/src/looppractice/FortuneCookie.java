

package looppractice;

import java.util.Random;
import java.util.Scanner;


public class FortuneCookie {
    
    public static void main(String[] args) {
        
        
        Random rGen=new Random();
        int randomNum= rGen.nextInt(4)+1;
        
        System.out.println("Are you ready for your fortune?");
        Scanner sc= new Scanner(System.in);
        String yesOrNo= sc.nextLine();
         
        
        
        
        if (yesOrNo.equals("yes")) {
               
                
                
                
        switch (randomNum) {
        
            case 1: 
                
                System.out.println("you will live");
                break;
                
            case 2: 
               
                System.out.println("you will die");
                break;
        
        
            }
        }
        
        else {
                
                System.out.println("You suck");
                        
                }
               
                
    }
}
