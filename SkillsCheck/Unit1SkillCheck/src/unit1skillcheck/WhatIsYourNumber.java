

package unit1skillcheck;

import java.util.Scanner;


public class WhatIsYourNumber {
    
    public static void main(String[] args) {
        
        
        
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Please enter a number");
        
        int userChoice=Integer.parseInt(sc.nextLine());
        
        System.out.println("You chose: " + userChoice);
        
        for (int i = 0; i <= userChoice; i++) {
            
            System.out.println(i);
            
        }
        
        System.out.println("Thank you for playing");
        
        
    }
}
