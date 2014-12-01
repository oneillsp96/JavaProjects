
package vendingmachine;

public class Change {
 
     public void calcChange(double input) {
        double totalinput = input;
        int qcounter = 0;
        int dcounter = 0;
        int ncounter = 0;
        int pcounter = 0;
        
        while (input >= .25) {
            qcounter++;
            input = (input - .25);
        }
        while (input >= .1) {
            dcounter++;
            input = (input - .1);
        }
        while (input >= .05) {
            ncounter++;
            input = (input - .05);
        }
        while (input >= .01) {
            pcounter++;
            input = (input - .01);
        }
        System.out.println("You received " + qcounter + " quarters, " + dcounter + " dimes, " + ncounter + " nickels, and " + pcounter + " pennies,"
                + " for a total of $" + totalinput + ".");
    }
    

}
