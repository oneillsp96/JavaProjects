package forloophomework;

import java.util.Scanner;

public class AddingValuesWithAForLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int userNum = Integer.parseInt(sc.nextLine());

        int sum = 0;

        for (int i = 1; i <= userNum; i++) {

            sum = sum + i;

            
            System.out.println("Current Number:" + i + "\t Current Sum: " + sum);
        

        }

    }
}
