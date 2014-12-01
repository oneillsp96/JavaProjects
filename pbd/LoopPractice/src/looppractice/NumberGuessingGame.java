package looppractice;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        System.out.println("Guess a number 1-10");

        Random rGen = new Random();

        int secretNumber = rGen.nextInt(10) + 1;

        Scanner sc = new Scanner(System.in);

        int guess = Integer.parseInt(sc.nextLine());

        
        
        
        
        if (guess == secretNumber) {
            System.out.println("You got it!");
        } 
        
        
        
        while (guess!=secretNumber) {
            System.out.println("Try again!");
            guess= Integer.parseInt(sc.nextLine());
        }
    }

}
