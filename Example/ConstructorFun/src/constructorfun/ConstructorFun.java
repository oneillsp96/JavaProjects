
package constructorfun;


public class ConstructorFun {

    
    public static void main(String[] args) {
        
//        
//        Dog dog1=new Dog("Fido");
//        
//        //dog1.setName("Fido");
//        dog1.bark();
//        
//        Retriever ret1=new Retriever("Buster");
//        
//        //ret1.setName("Buster");
//        ret1.bark();
//        ret1.hunt();
        
        
        
        //Retriever d1=new Dog("johnny");   //can't do this!
        
        Dog d2=new Retriever("sean");  // Retriever is-a Dog, Dog is not necessarily a Retriever
        
        Retriever r1= new Retriever("John");
        
        r1.hunt();
        
        
        
    }
    
}
