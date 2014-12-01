
package com.swcguild.flooringmasteryproject2.dao;

import com.swcguild.flooringmasteryproject2dao.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public interface OrderDao {
    
    public void writeOrders() throws IOException;
    public void loadOrders() throws FileNotFoundException, IOException;
    public ArrayList<Order> loadSpecificOrder(String file) throws FileNotFoundException;
    public void addOrder(Order order);
    public void removeOrder(Order order);
     public void addOrderAtPosition ( int position, Order order);
}
