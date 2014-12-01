/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryproject.dao;

import flooringmastery.ui.FlooringUI;
import flooringmasteryproject.dto.Order;
import flooringmasteryproject.logic.OrderFactory;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class DAOTest {
    
    public DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void daoTest() throws IOException {
        Order orderTest = new Order();
        OrderDAO od = new OrderDAO();
        TaxDAO td = new TaxDAO();
        ProductDAO pd = new ProductDAO();
        FlooringUI fui = new FlooringUI();
        OrderFactory of = new OrderFactory();
        Order a = new Order();
        a.setOrderNum(1);
        a.setCustomerName("Wise");
        a.setState("OH");
        a.setTaxRate(6.25);
        a.setProduct("Wood");
        a.setArea(100);
        a.setCostPerSqFt(5.15);
        a.setLaborPerSqFt(4.75);
        a.setMaterialCost(515);
        a.setLaborCost(475);
        a.setTaxOnTotal(61.88);
        a.setTotal(1051.88);
        
        Order b = new Order();
        b.setOrderNum(1);
        b.setCustomerName("Wise");
        b.setState("OH");
        b.setTaxRate(6.25);
        b.setProduct("Wood");
        b.setArea(100);
        b.setCostPerSqFt(5.15);
        b.setLaborPerSqFt(4.75);
        b.setMaterialCost(515);
        b.setLaborCost(475);
        b.setTaxOnTotal(61.88);
        b.setTotal(1051.88);
        
        
        
        ArrayList<Order> orderListTest = new ArrayList<>();
        
        OrderDAO od1 = new OrderDAO();
        OrderDAO od2 = new OrderDAO();

        Order e = of.createOrder("Wise", "OH", "Wood", 100);
        orderListTest.add(a);
        
        od1.writeOrders();
        
        ArrayList<Order> something = od1.loadSpecificOrder("testfile.txt");
        Order orderResult = orderListTest.get(0);
        orderTest = something.get(0);
        boolean r = compare(orderTest, orderResult);
        assertTrue(r);
        
        
    }

    
    public boolean compare(Order order1, Order order2) {
        boolean areEqual = false;
        if (order1.getOrderNum() == order2.getOrderNum() && 
            order1.getCustomerName().equals(order2.getCustomerName()) && 
            order1.getTaxRate() == order2.getTaxRate() && 
            order1.getProduct().equals(order2.getProduct()) && 
            order1.getCostPerSqFt() == order2.getCostPerSqFt() && 
            order1.getLaborPerSqFt() == order2.getLaborPerSqFt() && 
            order1.getMaterialCost() == order2.getMaterialCost() && 
            order1.getLaborCost() == order2.getLaborCost() && 
            order1.getTaxOnTotal() == order2.getTaxOnTotal() && 
            order1.getTotal() == order2.getTotal()) {
            areEqual = true;
        }
        return areEqual;
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
