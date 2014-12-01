
package flooringmasteryv2.dao;

import flooringmasteryv2.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public interface OrderDao {
    
    public void writeOrders() throws IOException;
    public void loadOrders() throws FileNotFoundException, IOException;
    public ArrayList<Order> loadSpecificOrder(String file) throws FileNotFoundException;
}
