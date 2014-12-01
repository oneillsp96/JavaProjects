package labs;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        Random rGen = new Random();

        int randomNum = rGen.nextInt(8) + 1;

        int rollOne = 0;
        int rollTwo = 0;
        int moneySum;
        int rollCount = 0;
        int maxAmount = 0;
        int rollSum;
        int addCount=0;

        System.out.println("How much money do you have to bet?");

        moneySum = Integer.parseInt(userInput.nextLine());

        maxAmount = moneySum;

        while (moneySum > 0) {

            rollOne = rGen.nextInt(6) + 1;
            rollTwo = rGen.nextInt(6) + 1;

            rollSum = rollOne + rollTwo;
            rollCount++;

            System.out.println("\n" + "You rolled " + rollSum);

            if (rollSum == 7) {

                moneySum += 4;
                maxAmount += 4;

                if (moneySum > maxAmount) {
                    maxAmount = moneySum;
                    addCount = rollCount;
                }

            } else {
                moneySum -= 1;

            }

            System.out.println("You have " + moneySum + " dollars remaining");

        }

        System.out.print("\n" + "You rolled " + rollCount + " times...");

        System.out.println("You should have stopped at " + addCount + " when you had + " + maxAmount);

    }
}
