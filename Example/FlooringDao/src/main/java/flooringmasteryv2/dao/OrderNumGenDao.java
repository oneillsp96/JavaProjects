
package flooringmasteryv2.dao;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface OrderNumGenDao {
    
    public int orderNumPlus() throws FileNotFoundException;
    public int orderNumGen()throws FileNotFoundException, IOException;
    public void orderNumWrite()throws IOException;
    
}
