
package functions.homework;


public class EvennessFunctions {
    
    public static void main(String[] args) {
        
        System.out.println(isEven(2));
        System.out.println(isDivisibleByThree(3));
        
        for (int i = 1; i < 21; i++) {
            
            if ( isEven(i) && isDivisibleByThree(i) ) {
                System.out.println(i+ "<=");
            } 
            
            else if (isDivisibleByThree(i)){
                System.out.println(i+ "=");
            }
            
            else if (isEven(i)) {
                System.out.println(i +"< ");
            }
            
            
            
            else {
                System.out.println(i);
            }
            
            
        }
        
    }
    
    
    public static boolean isEven(int n){
    
        
        if (n%2==0) {
        
            return true;
        }
        
        else {
        return false;
        }
        
       
    }
    
    public static boolean isDivisibleByThree(int x){
    
        if (x%3==0) {
        
            return true;
        }
        
        else {
        return false;
        }
    
    }
}
