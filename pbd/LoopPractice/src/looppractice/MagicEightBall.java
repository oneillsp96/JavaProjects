package looppractice;

import java.util.Random;
import java.util.Scanner;

public class MagicEightBall {

    public static void main(String[] args) {

        
      Random rGen= new Random();
      
      int choice= rGen.nextInt(8) +1;
      
        System.out.println("Welcome to magic 8 Ball....Choose a number");
        
        
      Scanner sc= new Scanner(System.in);
      choice=Integer.parseInt(sc.nextLine());
      
      
      switch (choice) {
          
          case 1: 
              System.out.println("Fate will smile upon you");
              break;
              
          case 2:
              System.out.println("You will probably die tomorrow");
              break;
              
          case 3: 
              System.out.println("You fortunes look good");
              break;
              
              
          default: System.out.println("Try again later");
      
      
      
      
      
      
      }
        
        
    }

}
