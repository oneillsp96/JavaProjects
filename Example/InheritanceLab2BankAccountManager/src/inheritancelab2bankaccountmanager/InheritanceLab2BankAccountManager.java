package inheritancelab2bankaccountmanager;

import java.util.Scanner;

public class InheritanceLab2BankAccountManager {

    public static void main(String[] args) {

        int choice1;
        ConsoleIO io = new ConsoleIO();
        Checking c1 = new Checking();
        Savings s1 = new Savings();

        do {

            choice1 = io.intBetweenPrompt("Main Menu- make a selection \n 1. Checking \n 2. savings ", 1, 2);

            switch (choice1) {

                case 1: // choice 1 = checking
//                System.out.println("1. Withdraw ");
//                System.out.println("2. Deposit");
                    int choice2 = io.intBetweenPrompt("1. Withdraw \n 2. Deposit", 1, 2);
                    if (choice2 == 1) {
                        c1.withdraw();
                    } else if (choice2 == 2) {
                        c1.deposit();
                    } else {
                        System.out.println("Invalid response");
                        break;
                    }
                    break;

                case 2: //choice 2=savings

                    int choice3 = io.intBetweenPrompt("1. Withdraw\n 2. Deposit", 1, 2);
                    if (choice3 == 1) {
                        s1.withdraw();
                    } else if (choice3 == 2) {
                        s1.deposit();
                    } else {
                        System.out.println("Invalid response");
                        break;
                    }
                    break;

            }

        } while (choice1 == 1 || choice1 == 2);

    }

}
