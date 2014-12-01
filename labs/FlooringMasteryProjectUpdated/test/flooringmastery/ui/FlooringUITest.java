/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmastery.ui;

import flooringmasteryproject.dao.OrderDAO;
import flooringmasteryproject.dto.Order;
import flooringmasteryproject.logic.OrderFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FlooringUITest {
    
    public FlooringUITest() {
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
    public void addOrder()throws FileNotFoundException, IOException {
        
        OrderFactory of = new OrderFactory();
        FlooringUI fui = new FlooringUI();
        OrderDAO od = new OrderDAO();
//        Order a = of.createOrder("Wise", "OH", "Wood", 100);
//        Order b = of.createOrder("Wise", "OH", "Wood", 100);
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
        orderListTest.add(a);
        orderListTest.add(b);

        Order aa = orderListTest.get(a.getOrderNum());
        Order bb = orderListTest.get(b.getOrderNum());
        boolean r = aa.equals(bb);
        assertTrue(r);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
