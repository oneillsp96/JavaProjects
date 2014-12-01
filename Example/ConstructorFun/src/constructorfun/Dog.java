
package constructorfun;


public class Dog {

    protected String name;
    
    public Dog(String name) {
        
        this.name=name;
        System.out.println("dog's String arg constructor");
    
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void bark() {
    
        System.out.println("WOOF!");
    
    }
}
