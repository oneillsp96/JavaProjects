
package rpgsatchel;


public class Sword implements Item {
    
    @Override
    public String getItemName() {
    return "Sword";
    }
    @Override                        //technically you're not overriding anything...similar to overriding abstract base class, there's nothing there but...
    public int getItemWeight(){
    return 15;
    }
    
    public void sharpen(){
    
        System.out.println("Sharpening...");
    }
    
    public void swing (){
    
        System.out.println("Swing...");
    }
    
}
