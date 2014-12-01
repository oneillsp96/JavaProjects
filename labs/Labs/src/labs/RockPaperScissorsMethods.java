

package labs;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissorsMethods {
    
    
 public static void main(String[] args) {

        int rock=1;
        int paper=2;
        int scissors=3;
        
        int comparisonValue;
        int maxRounds=10;
        int minRounds=1;
        int roundsChoice;
        
        int compWins=0;
        int youWin=0;
        int tie=0;
        String repeat="yes";
               
        
        
        
        while (repeat.equals("yes"))  {
        
        Random rGen= new Random();
        int compChoice= rGen.nextInt(3)+1;
        
        
        Scanner userInput=new Scanner(System.in);
        
        
            
            
            
        
        System.out.println("How many rounds would you like to play?");
        roundsChoice=userInput.nextInt();
        
        
        if (roundsChoice>0 && roundsChoice<10){
            
            
            
                 for (int i=1; i<=roundsChoice; i++)    { 
            
                
        
        
        System.out.println("Make a choice 1) rock 2) paper 3) scissors");
        
        
        
        int userChoice= userInput.nextInt();
        
            
        
               
        switch (userChoice) {
        
            case 1:
                
                System.out.println("you chose rock");
                
                if (compChoice==1){
                    System.out.println("computer also chose rock...Tie! ");
               tie++;
                }
            
                else if (compChoice==2){
                    System.out.println("computer chose paper...you lose!");
               compWins++;
                }
            
                else if (compChoice==3) {
                    System.out.println("computer chose scissors...you win!");
                youWin++;
                }
                
            
            break;
            
            
            case 2:
                
                System.out.println("you chose paper");
                
                
                
                if (compChoice==1){
                    System.out.println("computer chose rock...you win! ");
                youWin++;
                }
            
                else if (compChoice==2){
                    System.out.println("computer chose paper...tie!");
                tie++;
                }
            
                else if (compChoice==3) {
                    System.out.println("computer chose scissors...you lose!");
                compWins++;
                }
                
                
                break;
              
                
            case 3:    
                
                System.out.println("you chose scissors");
        
               
                if (compChoice==1){
                    System.out.println("computer chose rock... you lose! ");
               compWins++;
                }
            
                else if (compChoice==2){
                    System.out.println("computer chose paper...you win!");
                youWin++;
                }
            
                else if (compChoice==3) {
                    System.out.println("computer chose scissors...tie!");
                tie++;
                }
                 
        break;
        
//this bracket ends switch statement
                
                }
        
           
           
//this bracket ends for loop   
            }
        
            
        
           System.out.println("wins: " + youWin); 
           System.out.println("losses " + compWins);
           System.out.println("ties " + tie);
           
          
           
           
           declareWinner();
           
           
            
             repeat= userInput.nextLine();
             
        // bracket to close while loop ( play again)
        
        }
            
            
        
        else {
            System.out.println("enter a valid number of rounds (1-10)");
        }
        
        
            
    }
}

 
 
 public static void declareWinner() {
 
//            
//     if (youWin>compWins){           
//               System.out.println("overall winner: You!");
//           }
//           
//           else if (compWins>youWin){
//               System.out.println("overall winner: Computer!");
//           }
//           
//           else if (compWins==youWin) {
//               System.out.println("You tied the computer");
//           }
//           
//            System.out.println("Would you like to play again?");
 
 }
 
 
 
 
}   //last bracket in program
