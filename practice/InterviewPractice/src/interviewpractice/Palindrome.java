package interviewpractice;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();

        String reverse = new StringBuffer(x).reverse().toString();

        if (x.equalsIgnoreCase(reverse)) {
            System.out.println("It's a Palindrome");
        } else {
            System.out.println("Not a palindrome!");
        }

    }

}
