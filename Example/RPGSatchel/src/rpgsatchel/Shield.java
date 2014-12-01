
package rpgsatchel;


public class Shield implements Item {
    
    private String name;
    private int weight;
    
    //on this one we use a constructor, unlike sword....just 2 different ways to 'fulfill contract'
    
    public Shield(String name, int weight){
    this.name=name;
    this.weight=weight;
    }
    
    
    @Override
    public String getItemName(){
    return name;
    }
    
    @Override
    public int getItemWeight(){
    return weight;
    }

public void block(){
    
    System.out.println("Blocking...");

}


}

