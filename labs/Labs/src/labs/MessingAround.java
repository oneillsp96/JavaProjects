package labs;

import java.util.Random;

public class MessingAround {

    public static void main(String[] args) {

        System.out.println(randomGen());
        randomGen();

    }

    public static int randomGen() {

        Random rGen = new Random();
        int randomNumber = rGen.nextInt(10) + 1;

        return randomNumber;

    }

}
