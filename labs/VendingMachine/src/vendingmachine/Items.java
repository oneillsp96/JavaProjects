package vendingmachine;

/**
 *
 * @author apprentice
 */
public class Items {

    protected String name;
    protected double cost;
    protected int inventory;
    protected String coststring;
    protected String invstring;

//    public Items(String name, double cost, int inventory) {
//        this.name = name;
//        this.cost = cost;
//        this.inventory = inventory;
//    }
    public String getCoststring() {
        return coststring;
    }

    public void setCoststring(String coststring) {
        this.coststring = coststring;
    }

    public String getInvstring() {
        return invstring;
    }

    public void setInvstring(String invstring) {
        this.invstring = invstring;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

}
