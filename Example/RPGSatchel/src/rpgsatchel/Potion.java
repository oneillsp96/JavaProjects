
package rpgsatchel;

public class Potion implements MagicalItem {

    @Override
    public int getItemSpellpower() {
        return 23;
    }

    @Override
    public String getItemName() {
        return "potion";
    }

    @Override
    public int getItemWeight() {
        return 1;
    }
    
    
    
}
