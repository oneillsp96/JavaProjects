

package unit1skillcheck;


public class Counter {
    
    
    public static void main(String[] args) {
        
        
        to10();
        
        toN(3);
        toN(8);
        toN(200);
        
        
    }
    
    
    public static void to10 () {
    
        for(int i=1; i<=10; i++) {
        
        System.out.println(i);
        }
    }

    
    
    
    public static void toN(int n){
    
    for (int i=0; i<=n; i++ ) {
    
        System.out.println(i);
    } 
    
    }
    
    
    
    
}
