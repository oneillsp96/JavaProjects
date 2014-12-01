package functions.homework;


import java.util.Scanner;

public class KeychainsForSale {

    public static void main(String[] args) {
        KeychainsForSale ui = new KeychainsForSale();
        ui.run();

    }

    public void run() {
        int userChoice;

        do {
        
        System.out.println("Choose from the following: ");
        System.out.println("1. Add Keychain");
        System.out.println("2. Remove keychain");
        System.out.println("3. View all keychains");
        System.out.println("4. Checkout");
        Scanner sc = new Scanner(System.in);
        userChoice = Integer.parseInt(sc.nextLine());

        switch (userChoice) {

            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                view();
                break;
            case 4:
                checkout();
                //add code to exit program if checkout is called here    

                break; 
        }        
        
        } while (userChoice!=4);
        
        
        System.out.println("Thank you for checking out.  Goodbye.");

        

    }

    private void add() {

        System.out.println("Add method has been called");
    }

    private void remove() {
        System.out.println("Remove method has been called");
    }

    private void view() {

        System.out.println("View method has been called");
    }

    private void checkout() {

        System.out.println("Checkout has been called");

    }

}
