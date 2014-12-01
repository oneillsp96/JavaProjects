package looppractice;

import java.util.Scanner;

public class CountingWithAWhileLoop {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

       
        
        System.out.println("Type in a message");
        System.out.print("Message: ");
        String message = keyboard.nextLine();
        
        System.out.println("How many times would you like to display your message?");
        int displayTimes= Integer.parseInt(keyboard.nextLine());
        
        

        int n = 0;
        int i=10;
        
        
        while (n < displayTimes) {
            System.out.println((i) + ". " + message);
            n++;
            
            i+=10;
        }

    }
}
