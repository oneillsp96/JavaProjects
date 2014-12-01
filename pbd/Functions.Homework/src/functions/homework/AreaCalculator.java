

package functions.homework;

import java.util.Scanner;

public class AreaCalculator {
     
    public static void main(String[] args) {
        
        System.out.println("Enter the name of a shape and I will calculate it (circle, rectangle, square, triangle)");
        
        Scanner sc= new Scanner(System.in);
        
        String shapeChosen=sc.nextLine();

                    if (shapeChosen.equals("circle")) {

                        System.out.println("enter the radius");
                        int radius = Integer.parseInt(sc.nextLine());
                        
                        System.out.println("The area is: " + area_circle(radius));

                    }
                    
                    
                    else if (shapeChosen.equals("rectangle")) {
                    
                        System.out.println("Enter the length");
                        int length= Integer.parseInt(sc.nextLine());
                        System.out.println("Enter the width");
                        int width=Integer.parseInt(sc.nextLine());
                        System.out.println("The area is " + area_rectangle(length, width));
                    }
                    
                    else if (shapeChosen.equals("square")) {
                    
                        System.out.println("Enter the length");
                        int length= Integer.parseInt(sc.nextLine());
                        System.out.println("The area is " + area_square(length));
                    }
                    
                    else if (shapeChosen.equals("triangle")) {
                    
                        System.out.println("Enter the base");
                        int base= Integer.parseInt(sc.nextLine());
                        System.out.println("Enter the height");
                        int height=Integer.parseInt(sc.nextLine());
                         
                        System.out.println("The area is " + area_triangle(base, height));
                    }
                    
                    
                    else {
                        System.out.println("Start over and enter a valid shape");
                    }
                    
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static double area_circle (int radius) {
    
        double a=(Math.PI)*(radius)*(radius);
        
        return a;
        
    }
    
    
    
    
    
    public static int area_rectangle (int length, int width) {
    
        int a=(length*width);
        
        return a;
    
    }
    
    
    public static int area_square (int length) {
    
        int a=(length)*(length);
        
        return a;
    
    }
  
    public static double area_triangle (int base, int height) {
    
        double a=(base*height*0.5);
        
        return a;
    
    }
    
    
    
    
    
    
    
}
