
package arraylistshomework;

import java.util.ArrayList;
import java.util.Random;


public class BasicArrayLists3 {

    
    
    public static void main(String[] args) {
        
        
        ArrayList<Integer> myArrList=new ArrayList<>();
        
        
        Random rGen=new Random();
        
        for (int i = 1; i <= 1000; i++) {
            
            myArrList.add(rGen.nextInt(89)+10);
            
            
        }
        
        
        System.out.println("My Array List: " + myArrList);
        
        
        
    }
}
