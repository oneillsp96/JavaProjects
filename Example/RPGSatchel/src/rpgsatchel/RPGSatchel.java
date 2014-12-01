
package rpgsatchel;


public class RPGSatchel {

    
    public static void main(String[] args) {
        
        
        Sword weapon=new Sword();
        
        Shield protection= new Shield("Large Shield", 30);
        
        Satchel backpack=new Satchel(50);
        
        backpack.addToSatchel(weapon);
        backpack.addToSatchel(protection);
        
        
        //could also use MagicalItem magic=new Potion();  or Item magic=new Potion();
        
        
        
        
        Potion magic=new Potion();
        
        backpack.addToSatchel(magic);
        
        String[] items=backpack.listItemsInSatchel();
        
        for (int i=0; i<items.length; i++){
            System.out.println(items[i]);
        }
        
        
        
    }
    
}
