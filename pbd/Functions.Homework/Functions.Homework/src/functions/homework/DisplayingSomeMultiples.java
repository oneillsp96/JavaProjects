
package functions.homework;

import java.util.Scanner;


public class DisplayingSomeMultiples {
    
    public static void main(String[] args) {
        System.out.println("Enter a number and I will display "); 
       Scanner sc=new Scanner(System.in);
       int userNum=sc.nextInt();
        
        for (int i = 0; i < 10; i++) {
            
        System.out.println(userNum+"x"+ i+ "=" + (userNum*i));
            
        }
 
        
        
    }
}
