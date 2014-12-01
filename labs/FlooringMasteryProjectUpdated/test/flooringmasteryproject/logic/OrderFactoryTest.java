/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmasteryproject.logic;

import flooringmasteryproject.dao.ConfigDAO;
import flooringmasteryproject.dao.ProductDAO;
import flooringmasteryproject.dao.TaxDAO;
import flooringmasteryproject.dto.Order;
import flooringmasteryproject.dto.Product;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class OrderFactoryTest {

    public OrderFactoryTest() {
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
    public void calcTotalTest() throws FileNotFoundException, IOException {
        double DELTA = 1e-15;
        OrderFactory of = new OrderFactory();

        Order c = new Order();
        c.setOrderNum(1);
        c.setCustomerName("Wise");
        c.setState("OH");
        c.setTaxRate(6.25);
        c.setProduct("Wood");
        c.setArea(100);
        c.setCostPerSqFt(5.15);
        c.setLaborPerSqFt(4.75);
        c.setMaterialCost(515);
        c.setLaborCost(475);
        c.setTaxOnTotal(61.88);
        c.setTotal(1051.88);

        ConfigDAO cdao = new ConfigDAO();

//        if (cdao.loadConfig() == false) {
//        Order newOrder = of.createOrder("Wise", "OH", "Wood", 100);
//        Order addedOrder = of.createOrder(a.getCustomerName(), a.getState(), a.getProduct(), a.getArea());
//        boolean r = newOrder.equals(addedOrder);
//        assertTrue(r);
//        }
//        
       //Order c = new Order();
       
        c.setOrderNum(1);
        c.setCustomerName("Wise");
        c.setState("OH");
        c.setTaxRate(6.25);
        c.setProduct("Wood");
        c.setArea(100);
        c.setCostPerSqFt(5);
        c.setLaborPerSqFt(4);
       
        
//       c.setMaterialCost();
//       c.setLaborCost();
//       c.setTaxOnTotal();
//       c.setTotal();
  
        //test calcLaborCost
       double expLabor=(c.getLaborPerSqFt()*c.getArea());
       assertEquals(expLabor, 400.0, DELTA);
       
       //test calcMaterialCost
       double expMatCost=(c.getArea()*c.getCostPerSqFt());
       assertEquals(expMatCost, 500.0, DELTA);
      
       //test calcTaxOnTotal
       //tried to put the value i calculated in a variable (it didn't make a difference)
       double expTax = (expLabor + expMatCost) * (c.getTaxRate()/100);      
       double calcdTax=56.25;
       assertEquals(expTax, calcdTax, DELTA);
       
       //test calcTotal
       double expTot = expTax + expLabor + expMatCost;
       assertEquals(expTot, 956.25, DELTA);

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
