package looppractice;

import java.util.Scanner;

public class RunningTotal {

    public static void main(String[] args) {

        
        
        
        
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Please enter a number");
        int numberOne=Integer.parseInt(sc.nextLine());
        
        System.out.println("Please enter another number");
        int numberTwo=Integer.parseInt(sc.nextLine());
        
        int sum=numberOne+numberTwo;
        System.out.println("The sum of these numbers is: " + (sum));
       
        System.out.println("Would you like to enter another number?");
        
        String yesOrNo= sc.nextLine();
        
        
        
        while (yesOrNo.equals("yes")) {
        
            System.out.println("Add another number now");
            
            int numberThree=Integer.parseInt(sc.nextLine());   
            
            
            
            sum= (sum+numberThree);
            
            System.out.println("The sum of the numbers is " + sum);
        
       
        
        }
        
                
        
        System.out.println("Try again");
        
        
        
    }
}
