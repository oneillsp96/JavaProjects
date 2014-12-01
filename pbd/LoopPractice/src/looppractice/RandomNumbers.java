package looppractice;

import java.util.Random;

public class RandomNumbers {

    public static void main(String[] args) {

        
        Random rGen= new Random();
        
        int randomNumber= rGen.nextInt(8)+1;
        
        
        
        
               
        int number1= rGen.nextInt(8) +1;
        int number2= rGen.nextInt(8) +1;
        
        
        System.out.println("Here are some two random numbers: " + number1 + number2);
        
        
        if (number1==number2){
        
            System.out.println("The numbers were the same.  That's weird");
        
        }
        
        
        
        
    }
}
