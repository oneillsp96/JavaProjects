
package flooringmasteryv2.dao;

import java.io.FileNotFoundException;


public interface TaxDao {
    
    public double taxRate(String state);
     public String[] getStates();
     public void readTaxes()throws FileNotFoundException;
    
}
