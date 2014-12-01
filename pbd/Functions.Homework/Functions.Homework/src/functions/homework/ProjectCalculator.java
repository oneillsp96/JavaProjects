package functions.homework;

import java.util.Scanner;

public class ProjectCalculator {

    

    public static void main(String[] args) {
        
    System.out.println(">>");    
        
    Scanner sc = new Scanner(System.in);
    int a = Integer.parseInt(sc.next());
    String op = sc.next();
    int b=Integer.parseInt(sc.next());
    int c;

        
        if (op.equals("+")) {
            add(a, b);
            
        }
        
        
        
        
        
        
    }

    public static void add(int a, int b) {

        System.out.println(a + b);

    }
}
