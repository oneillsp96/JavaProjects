
package arrayshomework;

import java.util.Random;


public class BasicArrays3 {
    
public static void main(String[] args) {
        
        Random rGen=new Random();
        
        int randomNumber= rGen.nextInt(90)+10;
        
        int[]randomArray=new int[1000];
        
        
        
        for (int i=0; i<randomArray.length; i++) {
        
        
            randomArray[i]= rGen.nextInt(90)+10;
            
            
            System.out.print(randomArray[i] + "  ");
        
        
            
            
        }
        
    }
    
}
