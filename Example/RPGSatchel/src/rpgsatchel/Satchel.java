package rpgsatchel;

import java.util.HashMap;
import java.util.Set;

public class Satchel {
//similar to addressBook, dvdLibrary--> (DAO!)    

    private int weightLimit;
    private int currentWeight;

    HashMap<String, Item> itemMap = new HashMap<>();

    public Satchel(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public boolean addToSatchel(Item item) {

        if ((item.getItemWeight() + currentWeight) > weightLimit) {

            return false;

        } else {
            currentWeight += item.getItemWeight();
            itemMap.put(item.getItemName(), item);
            return true;
        }
    }

    public Item removeFromSatchel(String itemName) {
        Item temp = itemMap.remove(itemName);
        if (temp != null) {
            currentWeight -= temp.getItemWeight();

        }
        return temp;
    }
    public String[] listItemsInSatchel(){
    Set<String> keySet=itemMap.keySet();
    String [] keyArray=keySet.toArray(new String[0]);
    return keyArray;
    }

}
