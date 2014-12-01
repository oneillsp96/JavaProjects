package inheritancelab2bankaccountmanager;

import java.util.Scanner;

public class Savings extends SuperAccount {

    ConsoleIO io = new ConsoleIO();

    double savingsBalance;
    double userChoice;

    @Override
    public double withdraw() {

        userChoice = io.doublePrompt("Enter the amount to withdraw");

        savingsBalance = savingsBalance - userChoice;
        System.out.println("Current balance: " + savingsBalance);
        return savingsBalance;

    }

    @Override
    public double deposit() {

        userChoice = io.doublePrompt("Enter the amount to deposit");

        savingsBalance = savingsBalance + userChoice;
        System.out.println("Current balance: " + savingsBalance);

        return savingsBalance;

    }

}
