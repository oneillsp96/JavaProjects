
package arrayshomework;

import java.util.Random;

public class BasicArrays2 {
    
    public static void main(String[] args) {
        
        Random rGen=new Random();
        int randomNumber= rGen.nextInt(10)+1;
        
        int[]randomArray=new int[10];
        
        
        randomArray[0]= rGen.nextInt(10)+1;
        randomArray[1]= rGen.nextInt(10)+1;
        randomArray[2]= rGen.nextInt(10)+1;
        randomArray[3]= rGen.nextInt(10)+1;
        randomArray[4]= rGen.nextInt(10)+1;
        randomArray[5]= rGen.nextInt(10)+1;
        randomArray[6]= rGen.nextInt(10)+1;
        randomArray[7]= rGen.nextInt(10)+1;
        randomArray[8]= rGen.nextInt(10)+1;
        randomArray[9]= rGen.nextInt(10)+1;
        
        
        for (int i=0; i<randomArray.length; i++) {
        
        
            System.out.println(randomArray[i]);
        
        
        }
        
    }
    
}
