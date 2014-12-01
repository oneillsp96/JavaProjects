
package looppractice;

import java.util.Random;
import java.util.Scanner;

public class OneShotHiLo {
    
    
    public static void main(String[] args) {
        
        Random rGen= new Random();
        Scanner sc= new Scanner(System.in);
               
       int randomNumber=rGen.nextInt(100)+1;
       
        System.out.println("random number is " + randomNumber);
        
        System.out.println("Guess a number 1-100");
        int userGuess=Integer.parseInt(sc.nextLine());
        
        if (userGuess==randomNumber) {
        
            System.out.println("You got it!");
        }
        else if (userGuess>randomNumber) {
            System.out.println("too high");
        }
        
        else {
            System.out.println("too low");
        }
        
        
    }
}
