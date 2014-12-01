package inheritancelab2bankaccountmanager;

import java.util.Scanner;

public class Checking extends SuperAccount {

    ConsoleIO io = new ConsoleIO();
    double checkingBalance;
    double userChoice;

    @Override
    public double withdraw() {

        userChoice = io.doublePrompt("Enter the amount to withdraw");

        checkingBalance = checkingBalance - userChoice;

        System.out.println("Current balance: " + checkingBalance);
        return checkingBalance;

    }

    @Override
    public double deposit() {

        userChoice = io.doublePrompt("Enter the amount to deposit");

        checkingBalance = checkingBalance + userChoice;
        System.out.println("Current balance: " + checkingBalance);

        return checkingBalance;
    }

}
