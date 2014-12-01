//I know there's a better way to do this




package looppractice;

import java.util.Scanner;


public class RightTriangleChecker {
    
    public static void main(String[] args) {
        
        Scanner sc= new Scanner (System.in);
        
        System.out.println("Welcome to right triangle checker.  Enter 3 values in ascending order. \n");
        
        
        System.out.println("Enter length of side 1");
        int side1=Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter length of side 2");
        int side2=Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter side 3");
        int side3=Integer.parseInt(sc.nextLine());
        
        
        System.out.println("Your sides are: " + side1 + ", " + side2 + ", " + side3);
        
        
        
        
        while (side1>side2 || side2>side3 || side1>side3) {
        
        System.out.println("Please enter the values in ascending order");
        System.out.println("Enter length of side 1");
        side1=Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter length of side 2");
        side2=Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter side 3");
        side3=Integer.parseInt(sc.nextLine());
        
        
        System.out.println("Your sides are: " + side1 + ", " + side2 + ", " + side3);
        
        }
            
            
        
        
        if (    ((side1)*(side1)+(side2)*(side2))==((side3)*(side3))    ) {
        
            System.out.println("A triangle with those side lenths is a right triangle");
            
        
        }
        
        else { 
            System.out.println("That's not a right triangle");
        }
        
        
        
        
    
    
    }
   
}
