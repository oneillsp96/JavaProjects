
package arraylistshomework;

import java.util.ArrayList;
import java.util.Random;

public class BasicArrayLists2 {
    
    public static void main(String[] args) {
        
        
        ArrayList<Integer> myArrList= new ArrayList<Integer>();
        
        Random rGen=new Random();
       
       
        for (int i = 1; i <= 100; i++) {
            
            myArrList.add(rGen.nextInt(100)+1);
            
        }
        
               
//        for (int j=1; j<=myArrList.size(); j++) {
//            
//            System.out.println(myArrList.get(j));
//        
//        }
        
        
        //easier way to print than what was commented out above
        
        System.out.println( "ArrayList: " + myArrList);
        
        
        
        
        
        
    }
}
