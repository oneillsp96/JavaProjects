
package constructorfun;


public class Retriever extends Dog{
    
    
    public Retriever(String name){
    super(name);
        System.out.println("retriever's default constructor");   
    }
    
  public void hunt(){
  
      System.out.println("Retriever hunting...");
  }
    
    
}
