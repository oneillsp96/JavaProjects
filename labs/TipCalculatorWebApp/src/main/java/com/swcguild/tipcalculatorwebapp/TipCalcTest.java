
package com.swcguild.tipcalculatorwebapp;

import java.util.Scanner;

public class TipCalcTest {
    public static void main(String[] args) {
        
        
        System.out.println("Enter the cost of the meal");
        Scanner sc=new Scanner(System.in);
        double cost=Double.parseDouble(sc.nextLine());
        
         System.out.println("Enter the tip percentage___%");
        Scanner sc2=new Scanner(System.in);
        double tipPercentage=Double.parseDouble(sc2.nextLine());
        double tipRatio=tipPercentage/100;
        
        System.out.println("Tip Percentage: " + tipPercentage + "%");
        System.out.println("Tip: $" + tipRatio*cost);
        System.out.println("Total Cost: $" + (tipRatio*cost +cost ));
        
        
        
    }
        
}
