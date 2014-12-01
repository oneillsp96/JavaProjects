
package unit1skillcheck;


public class AreTheyTrue {
    
    public static void main(String[] args) {
        
        
        System.out.println(howTrue(true, true));
        System.out.println(howTrue(false, false));
        System.out.println(howTrue(true, false));
        System.out.println(howTrue(false, true));
        
        
                
        
    }
    
    
    public static String howTrue(boolean a, boolean b){
    
    String x= "neither";
    String y= "both";
    String z= "only 1";
    String ttt= "";
        
        
    if ( a==false && b==false ) {
    ttt= x;
  
    }
    
        
    else if ( a==true && b==true ) {
    ttt= y;
  
    }
    
    else if ( a==true && b==false ) {
    ttt= z;
  
    }
    
    else if ( a==false && b==true ) {
    ttt= z;
  
    }
    
    
    
    
    
    
    
    
return ttt ;
    }

}