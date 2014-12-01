package arraylistshomework;

import java.util.ArrayList;
import java.util.Random;

public class LocatingTheLargestValueInAnArray {

    public static void main(String[] args) {

        ArrayList<Integer> myArrList = new ArrayList<>();

        Random rGen = new Random();

        for (int i = 1; i <= 100; i++) {

            myArrList.add(rGen.nextInt(100) + 1);

        }

        System.out.println("My Array List: " + myArrList);

        int max = 0;

        for (int j = 1; j < myArrList.size(); j++) {

            if (myArrList.get(j) > max) {

                max = j;

            }

        }
        System.out.println("The maximum value in the arraylist is: " + max);

        for (int j = 0; j < myArrList.size(); j++) {

            if (max == myArrList.get(j)) {

                System.out.println(max + " is located at slot: " + j);
            }
        }

    }
}
