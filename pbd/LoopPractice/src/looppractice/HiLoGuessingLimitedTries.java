package looppractice;

import java.util.Random;
import java.util.Scanner;

public class HiLoGuessingLimitedTries {

    public static void main(String[] args) {

        System.out.println("guess the number 1-10");
        
        Scanner myScanner= new Scanner(System.in);
        int userGuess=Integer.parseInt(myScanner.nextLine());
        
        
        Random rGen= new Random();
        
        int secretNumber= rGen.nextInt(10)+1;
        
        int numberOfGuesses=0;
        
        while (userGuess!=secretNumber && numberOfGuesses<=4){
        
            System.out.println("try again");
                      
            
            userGuess=Integer.parseInt(myScanner.nextLine());
            
            numberOfGuesses++;
                     
            
                        
        }
         
        
            if (userGuess==secretNumber) {
                System.out.println("you got it");
            }
            
            else {
            System.out.println("you ran out of guesses");
            }
        
        
        
        
    }
}
