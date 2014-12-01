
package flooringmasteryv2.dao;

import java.io.FileNotFoundException;


public interface ProductDao {
    
    public String[] getProducts();
    public double matCost(String product);
    public double labCost(String product);
    public void readProductCost()throws FileNotFoundException;
    
}
