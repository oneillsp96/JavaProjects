package labs;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        int rock = 1;
        int paper = 2;
        int scissors = 3;

        int comparisonValue;

        Random rGen = new Random();
        int compChoice = rGen.nextInt(3) + 1;

        System.out.println("Make a choice 1)rock 2)paper 3) scissors");

        Scanner userInput = new Scanner(System.in);
        int userChoice = userInput.nextInt();

        switch (userChoice) {

            case 1:

                System.out.println("you chose rock");

                if (compChoice == 1) {
                    System.out.println("computer also chose rock...Tie! ");
                } else if (compChoice == 2) {
                    System.out.println("computer chose paper...you lose!");
                } else if (compChoice == 3) {
                    System.out.println("computer chose scissors...you win!");
                }

                break;

            case 2:

                System.out.println("you chose paper");

                if (compChoice == 1) {
                    System.out.println("computer chose rock...you win! ");
                } else if (compChoice == 2) {
                    System.out.println("computer chose paper...tie!");
                } else if (compChoice == 3) {
                    System.out.println("computer chose scissors...you lose!");
                }

                break;

            case 3:

                System.out.println("you chose scissors");

                if (compChoice == 1) {
                    System.out.println("computer chose rock...you lose! ");
                } else if (compChoice == 2) {
                    System.out.println("computer chose paper...you win!");
                } else if (compChoice == 3) {
                    System.out.println("computer chose scissors...tie!");
                }

                break;

        }

    }
}
