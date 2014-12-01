
package functions.homework;

import java.util.Scanner;


public class KeychainsForReal {
    
 public static void main(String[] args) {
        KeychainsForReal ui = new KeychainsForReal();
        ui.run();

    }
    int currentNumber=0;
    int pricePer=10;
    Scanner sc2= new Scanner(System.in);
    private void run() {
        
        
       
        int userChoice;

        do {
        
        System.out.println("Choose from the following: ");
        System.out.println("1. Add keychains");
        System.out.println("2. Remove keychains");
        System.out.println("3. View all keychains");
        System.out.println("4. Checkout");
        Scanner sc1 = new Scanner(System.in);
        userChoice = Integer.parseInt(sc1.nextLine());

        switch (userChoice) {

            case 1:
                add1();
                break;
            case 2:
                remove1();
                break;
            case 3:
                view1();
                break;
            case 4:
                checkout1();
                //add code to exit program if checkout is called here    

                break; 
        }        
        
        } while (userChoice!=4);
        
        
        

        

    }

    
    private int add1() {

        System.out.println("How many would you like to add?");
        int inputAdd=Integer.parseInt(sc2.nextLine());
        currentNumber=currentNumber+inputAdd;
        
        
        System.out.println("You added a keychain, you now have: " + currentNumber );
        
        return currentNumber;
    }

    private int remove1() {
        currentNumber--;
        System.out.println("You removed a keychain, you now have: " + currentNumber );
    return currentNumber;
    
    }

    private void view1() {

        System.out.println("Price per keychain: " + pricePer);
        System.out.println("Number of keychains in cart: " + currentNumber);
        System.out.println("Total order cost: $" + (pricePer*currentNumber));
    }

    private void checkout1() {

        System.out.println("Thank you for order!  Goodbye.");

    }

}

