/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryv2Tests;


import com.swcguild.flooringmasteryproject2.dao.OrderDaoImpl;
import com.swcguild.flooringmasteryproject2dao.model.Order;
import com.swcguild.flooringmasteryproject2.logic.OrderFactory;
import flooringmasteryproject2.ui.FlooringUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class FlooringUITest {
    OrderFactory of;
    FlooringUI fui;
     OrderDaoImpl od;
    
    
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
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        of=(OrderFactory) ctx.getBean("of");
        od=(OrderDaoImpl) ctx.getBean("od");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addOrder()throws FileNotFoundException, IOException {
        
      
       fui = new FlooringUI();
       
        
    //    Order a = of.createOrder("Wise", "OH", "Wood", 100);
     //  Order b = of.createOrder("Wise", "OH", "Wood", 100);
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
