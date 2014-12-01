package forloophomework;

import java.util.Scanner;

public class CountingMachineRevisited {
 
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your first number");
        int num1= Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter your second number");
        int num2=Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter your third number");
        int num3=Integer.parseInt(sc.nextLine());
                
         
        
        
        for (int i= num1; i <= num2; i+=num3) {
            
            
            System.out.println(i);
        }
        
        
        
        
        
        
        
    }
}
