
package looppractice;

import java.util.Scanner;

public class AddingValuesInALoop {
    
    
    public static void main(String[] args) {
        
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("I will add up the numbers you give me.  Enter your first number");
        
        int sum=Integer.parseInt(sc.nextLine());
        
        System.out.println("You chose " + sum);
                
        while (sum!=0) {
            
            
            System.out.println("enter another number");
            int nextNumber=Integer.parseInt(sc.nextLine());
            
            
            sum= (sum + nextNumber);
        
            System.out.println("Sum: " + sum);
        
        
        
        }
        
       
        System.out.println("Number must be a positive integer. Try again");
    }
    
    
    
}
