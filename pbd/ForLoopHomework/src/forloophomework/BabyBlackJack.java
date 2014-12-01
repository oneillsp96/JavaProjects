
package forloophomework;

import java.util.Random;
import java.util.Scanner;


public class BabyBlackJack {
    
    
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        
       
        Random rGen= new Random();
        
        int userCard1=rGen.nextInt(10) +1;
        int userCard2= rGen.nextInt(10) +1;
        int compCard1= rGen.nextInt(10)+1;
        int compCard2=rGen.nextInt(10) +1;
        
        int userSum= userCard1+ userCard2;
        int compSum=compCard1+ compCard2;
        
        System.out.println("You drew " + userCard1 + " and " + userCard2);
        System.out.println("Your total is " + userSum);
        
        System.out.println("\nThe dealer drew " + compCard1 + " and " + compCard2);
        System.out.println("The dealer's total is " + compSum);
        
        System.out.println();
        
        if (compSum>userSum) {
            System.out.println("You lose");
        
        }
        
        else {
            System.out.println("You win");
        }
    
    
    
    }
}
