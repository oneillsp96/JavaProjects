
package arraylistshomework;

import java.util.ArrayList;
import java.util.Random;


public class CopyingArrayLists {
    
    

    public static void main(String[] args) {
        
        
        ArrayList<Integer> myArrList=new ArrayList<>();
        
        
        Random rGen=new Random();
        
        for (int i = 1; i <= 10; i++) {
            
            myArrList.add(rGen.nextInt(100)+1);
            
            
        }
        
        
        System.out.println("My Array List: " + myArrList);
        
        
        
        ArrayList<Integer> copiedList=new ArrayList<Integer>();
        
        
        for (int i = 0; i <myArrList.size(); i++) {
            
            copiedList.add(myArrList.get(i));
        }

        System.out.println("Copied List:   " + copiedList);
    
        
        
        //set value of position 9 (last number) to -7
        
        myArrList.set(9,-7);
                
        System.out.println("New List:      " +  myArrList);
       
    
    
    
    
    }

}