
package arraylistshomework;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ArrayListWhereIsIt {
 
    
public static void main(String[] args) {

         ArrayList <Integer> myArrList= new ArrayList<>();
        
        Random rGen=new Random();
        
        for (int i = 1; i <=10; i++) {
            
            myArrList.add(rGen.nextInt(50)+1);
            
        }
        
        System.out.println("My Array List: " + myArrList);
               
        System.out.println("Please enter an integer");
        Scanner sc=new Scanner(System.in);
        int userInt=Integer.parseInt(sc.nextLine());
        
        int counter=0; 
        
        for (int j=0; j<myArrList.size(); j++) {
        
        if (userInt==myArrList.get(j)){
            
            System.out.println("That number is in the array at position: " + j);
            
            
            counter++;
        }
            
            }
        
        
        
        
        
        
        
        
         if (counter > 0) {
            System.out.println(userInt + " is in the array list " + counter + " times");
        } else {
            System.out.println("That number is not in the array list");
        }
            
    





}

}
