

package looppractice;

import java.util.Scanner;


public class SafeSquareRoot {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number and I will tell you the square root");
        
        double userNumber= Double.parseDouble(sc.nextLine());
        
        while (userNumber<0) {
        
            System.out.println("Please enter a non-negative value");
            userNumber=Double.parseDouble(sc.nextLine());
            
        }
        
        double squareroot= Math.sqrt(userNumber);
        System.out.println(squareroot);
    }
}
