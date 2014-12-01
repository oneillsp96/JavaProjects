
package collectionsexample;


public class NonStaticFromMainExample {
    
    
    public static void main(String[] args) {
        
        //need to instatitate "ourself" to use  non-static  
        
        NonStaticFromMainExample foo=new NonStaticFromMainExample();
        
        
       int sum;
       
        sum=foo.add(4,6);
        System.out.println(sum);
        
        
          //this doesn't work--cannot be referenced from static context
//        System.out.println(add(4,8));
        
        
    }
    
    
    public int add(int a, int b) {
    
    
    return (a+b);
    
    }
    
    public int subtract (int a, int b){
    
    return (a-b);
    }
    
    
}
