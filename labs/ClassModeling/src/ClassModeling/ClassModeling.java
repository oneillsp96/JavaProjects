
package ClassModeling;

import java.util.Scanner;


public class ClassModeling {

   
    public static void main(String[] args) {
        
        Car car1= new Car();  //needs a constructor in other file!!
        
        car1.setCarMake("Ford");
        car1.setCarModel("Fiesta");
        car1.setHorsePower(179);
        
        System.out.println(car1.getCarMake() + " " + car1.getCarModel() + " " + car1.getHorsePower());
        
        
        
        
        System.out.println("Enter the RPM level (low, mid, high)");
        Scanner sc=new Scanner(System.in);
        String input= sc.nextLine();
                
        
        System.out.println(car1.soundMadeAt(input));
        
        
        
        
        
        
        
        
        
        
        
        //Alternate way to create objects
        //Don't need setters in this case?? Ask eric
        
        
        City city1= new City("Dayton", 500000, 300);
        City city2=new City("Columbus", 900000, 190);
        City city3=new City("Toldeo", 80000, 230);
        
                
        System.out.println(city1.getName());
        System.out.println(city2.getName());
        System.out.println(city3.getPopulation());
        
        
        
        
        
        
        
    }
    
}
