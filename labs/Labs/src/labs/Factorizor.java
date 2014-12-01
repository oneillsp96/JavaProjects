
/*In this lab you will write a program that calculates all the factors of a number entered by the user. 
The program must print out the original number along with each of its factors. The program must 
also tell the user if the number is a perfect number. A perfect number is a number where all the 
factors of the number add up to that number. For example, the first perfect number is 6 because 
its factors 1, 2, and 3 add up to 6. Additionally, the program must tell the user whether or not the 
number is a prime number. A prime number is defined as a number that has only itself and 1 as 
factors. For example, 3 is a prime number.  
 
Your program must have the following features:  
 
1. This program must be a Java Console Application called Factorizor.  
2. This program must ask the user the number for which he/she wants to factor.  
3. The program must print out the original number.  
4. The program must print out the total number of factors for the number.  
5. The program must print out each factor of the number (not including the number itself).  
6. The program must print out whether or not the number is perfect.  
7. The program must print out whether or not the number is prime. = 
*/



package labs;

import java.util.Scanner;

public class Factorizor {
 
    
    public static void main(String[] args) {
        
        
        
        int iTotal=0;
        int factorCount=0;
        
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("What number would you like to factor");
        
        int numberToFactor= Integer.parseInt(sc.nextLine());
        
        System.out.println("The factors of " + numberToFactor + " are: ");
        
        
        for (int i =1; i< numberToFactor; i++){
        
        
        
                    if (numberToFactor%i==0) {
                    
                        System.out.println(i);
                        iTotal+=i;
                        factorCount+=1;
                    
                    }
                         
        }
        
        
        //test for perfect number
        
        if(iTotal==numberToFactor) {
        
            System.out.println(numberToFactor + " is a perfect number");        
        }
        
        else  {
        
        System.out.println(numberToFactor + " is not a perfect number");
    
    
    }
        
        
        
        
        //Test is number is prime
        
        if (factorCount==1) {
        
            System.out.println(numberToFactor + " is a prime number");
            
        }
        
        else {
        
            System.out.println(numberToFactor + " is not a prime number");
        }
        
        
        
        
    }
    
}
