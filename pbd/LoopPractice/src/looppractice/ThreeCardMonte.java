package looppractice;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {

        
        Random rGen= new Random();
        int whichCard=rGen.nextInt(3)+1;
        
        Scanner sc=new Scanner(System.in);
        
        
        
        System.out.println("On the table are 3 cards....which one is the ace?");
        //easier to draw graphics on new println
        System.out.println(" 1) ### " + "2) ### " + "3) ###");
        
        int userGuess=Integer.parseInt(sc.nextLine());
        
        if (userGuess==whichCard) {
        
        
             if (whichCard==1) {
            
            System.out.println("1) AAA 2) ### 3) ###     You win!");
        
            }
        
            else if (whichCard==2) {
            
               System.out.println("1) ### 2) AAA 3) ###     You win!");
        
            }
        
        
            else if (whichCard==3 ) {
            
            System.out.println("1) ### 2) ### 3) AAA     You win!");
        
                        }
        
        }   
            
        
        else {
        
                 if (whichCard==1) {
            
                     System.out.println("1) AAA 2) ### 3) ###     You lose!");
        
                     }
        
                     else if (whichCard==2) {
            
                        System.out.println("1) ### 2) AAA 3) ###     You lose!");
        
                      }
        
        
                       else if (whichCard==3 ) {
            
                      System.out.println("1) ### 2) ### 3) AAA     You lose!");
        
                                  }
                 
            
            
        }
                
       
        
        
        
    }
}
