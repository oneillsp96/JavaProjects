

package forloophomework;

import java.util.Scanner;


public class CountingMachine {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter a number and I will count up to it:");
        int choice=Integer.parseInt(sc.nextLine());
        
        for (int i=1; i<=choice; i++) {
        
            System.out.println(i);
        }
        
        
                
    }
}
