/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {

    private Scanner sc = new Scanner(System.in); //readable by all methods
    private int intmin = 1;
    private int intmax = 6;
    private float flmin = 25;
    private float flmax = 75;
    private double dmin = 15.25;
    private double dmax = 100.75;
    public Scanner ss = new Scanner(System.in);
    public Scanner s1 = new Scanner(System.in);

    public int integerPrompt(String message) {
        int input = 0;
        boolean isInvalidInput = true;
        do {
            try {
                System.out.println(message);
                String inputString = sc.nextLine();
                input = Integer.parseInt(inputString); //stops executing here in the try/catch thing
                isInvalidInput = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Your input must be an integer. Please try again");
            }
        } while (isInvalidInput);
        return input;
    }

    public int integerPromptLimits(String message) {
        boolean isInvalidInput = true;
        int input = 0;
        do {
            isInvalidInput = true;
            System.out.println(message);
            String inputs = sc.nextLine();
            try {
                input = Integer.parseInt(inputs);
                isInvalidInput = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid integer - please enter a valid integer");
            }
        } while ((input < intmin || input > intmax) || isInvalidInput);
//        while (input < intmin || input > intmax) {
//            System.out.println("Please choose an option between " + intmin + " and " + intmax);
//            inputs = sc.nextLine();
//            input = Integer.parseInt(inputs);
//        }
            return input;
        }

    public String stringPrompt(String message) {
        System.out.println(message);
        String input = sc.nextLine();
        return input;
    }

    public float floatPrompt(String message) {
        System.out.println(message);
        String input = sc.nextLine();
        return Float.parseFloat(input);
    }

    public float floatPropmtLimits(String message) {
        System.out.println(message);
        String inputs = sc.nextLine();
        float input = Float.parseFloat(inputs);
        while (input < flmin || input > flmax) {
            System.out.println("Please choose a number between " + flmin + " and " + flmax);
            inputs = sc.nextLine();
            input = Float.parseFloat(inputs);
        }
        return input;
    }

    public double doublePrompt(String message) {
        double inputd;
        do {
            System.out.println(message);
            while (!ss.hasNextDouble()) {
                p("Please enter a number.");
                ss.next();
            }
            inputd = ss.nextDouble();
        } while (inputd <= 0);
        return inputd;
    }

    public double doublePromptLimits(String message) {
        System.out.println(message);
        String inputs = sc.nextLine();
        double input = Double.parseDouble(inputs);
        while (input < dmin || input > dmax) {
            System.out.println("Please enter a double between " + dmin + " and " + dmax);
            inputs = sc.nextLine();
            input = Double.parseDouble(inputs);
        }
        return input;
    }

    public void p(String message) {
        System.out.println(message);
    }

    public void pp(String message) {
        System.out.print(message);
    }

}
