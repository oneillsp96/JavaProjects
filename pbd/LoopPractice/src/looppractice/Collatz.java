package looppractice;

import java.util.Scanner;

public class Collatz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number");
        int number = Integer.parseInt(sc.nextLine());

        while (number != 1) {

            if (number % 2 == 0) {

                number = number / 2;

                System.out.println(number);

            } else {

                number = ((number * 3) + 1);

                System.out.println(number);

            }

        }

    }
}
