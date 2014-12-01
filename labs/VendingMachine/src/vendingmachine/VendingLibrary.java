
package vendingmachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class VendingLibrary {
    
    
    HashMap<String, Items> myitems = new HashMap<>();
    private String INVENTORY_FILE = "vending-inventory.txt";
    private String DELIMITER = "::";
    ConsoleIO io = new ConsoleIO();
    Change ch = new Change();
    Items chips = myitems.get("Chips");
    Items cookies = myitems.get("Cookies");
    Items Gum = myitems.get("Gum");
    
    public void run()throws Exception {
        String choice = "";
        
        readVending();
        printAllItems(viewAllItems());
        double money = io.doublePrompt("Please insert money");
        
       
            choice = io.stringPrompt("Please make a selection.");  
        
        Items buy = getItem(choice);
        if (money >= buy.getCost()) {
            System.out.println("You recieved your " + buy.getName());
            int updateInv = buy.getInventory();
            updateInv--;
            buy.setInventory(updateInv);
            addItem(choice, buy);
            money -= buy.getCost();
            ch.calcChange(money);
        }
        else if (money < buy.getCost()) {
            System.out.println("Sorry, but you don't have enough money.");
            ch.calcChange(money);
        }
        writeVending();
        
    }
    
    public Items addItem(String name, Items itemToAdd) {
        return myitems.put(name, itemToAdd);
    }



public void printItem(Items i) {
        System.out.println(i.getName() + "\t" + "$" + i.getCost() + "\t" + i.getInventory());
    }

    public void printAllItems(Items[] item) {
        System.out.println("Item" + "\t" + "$" + "Cost" + "\t" + "remaining");
        for (Items i : item) {
            if (i.getInventory() != 0) {
                printItem(i);
            }
            else {
                System.out.println(i.getName() + " is out of stock.");
            }
        }
    }
    
    public Items[] viewAllItems() {
        Collection<Items> allItems = myitems.values();
        Items[] allItemsArray = new Items[allItems.size()];
        allItemsArray = allItems.toArray(allItemsArray);
        return allItemsArray;
    }
    
    public void vendingInventory() throws IOException {
        String[] itemNames = {"Chips", "Cookies", "Gum"};
        Double[] itemCost = {1.25, 1.40, .65};
        int[] itemInv = {8, 6, 5};
        for (int i = 0; i < itemNames.length; i++) {
            Items newItem = new Items();
            newItem.setName(itemNames[i]);
            newItem.setCost(itemCost[i]);
            newItem.setInventory(itemInv[i]);
            myitems.put(newItem.getName(), newItem);
        }
        this.writeVending();
    }

    public String[] getAllItems() {
        Set<String> keySet = myitems.keySet();
        String[] keyArray = keySet.toArray(new String[0]);
        return keyArray;
    }

    public Items getItem(String name) {
        return myitems.get(name);
    }

    public void writeVending()throws IOException  {
        PrintWriter out = new PrintWriter(new FileWriter(INVENTORY_FILE));

        String[] keys = this.getAllItems();
        for (String key : keys) {
            Items i = this.getItem(key);
            out.println(i.getName() + DELIMITER
                    + i.getCost() + DELIMITER
                    + i.getInventory());
            out.flush();
        }
        out.close();
       
    }

    public void readVending()throws FileNotFoundException   {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        String currentLine;
        String[] token = new String[3];

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            token = currentLine.split(DELIMITER);

            Items i = new Items();
            i.setName(token[0]);
            i.setCost(Double.parseDouble(token[1]));
            i.setInventory(Integer.parseInt(token[2]));

            myitems.put(token[0], i);
        }
        sc.close();
    }

}




