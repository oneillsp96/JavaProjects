//  Need to learn exceptions to use system.in read

package arrayshomework;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class HangMan {
    
    public static void main(String[] args) throws StringIndexOutOfBoundsException, IOException          
            {
        
        String[] words = { "Zebra", "Apple", "Buggs", "Altos", "Table" };
        
        Random rGen=new Random();
        
        String randomWord= words[rGen.nextInt(4)];
        
        System.out.println("The secret word is: " + randomWord);
        
        
       try { 
        System.out.println("Let's play Hangman.  Enter your first letter guess.");
        Scanner sc= new Scanner(System.in);        
       
        char userGuess=(char) System.in.read();   
        
          System.out.println("You guessed: " + userGuess);
       
       
       
      
        
        
        char [] charArray= new char[5];
        
        
        for (int i = 0; i <=randomWord.length(); i++) {
           
            //fills array with characters from secret word in order
            charArray[i]= randomWord.charAt(i);
            
            System.out.print(charArray[i] + "   ");
        
        
        if (userGuess==charArray[i]) {
           
               System.out.println("you guessed correctly?.....");
                System.out.println("There was a" + userGuess + "at position number" + i); 
        
             }
        
        }
             
           
//        
//        
//        for (int i=0; i<=randomWord.length(); i++) {
//        
//             if (userGuess==charArray[i]) {
//           
//               System.out.println("you guessed correctly?.....");
//                System.out.println("There was a" + userGuess + "at position number" + i); 
//        
//             }
//        
//        }
//                    

        
    
    
    
    
       
       } //ends try block
    
       catch (IOException e) {
           
       }
       
      
       
       
       
       
       
        }
        
        
   
    
    
    
    
    
}
        
    
        



