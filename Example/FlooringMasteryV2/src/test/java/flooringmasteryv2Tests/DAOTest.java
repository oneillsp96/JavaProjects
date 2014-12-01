/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryv2Tests;



import com.swcguild.flooringmasteryproject2.dao.OrderDao;
import com.swcguild.flooringmasteryproject2.dao.OrderDaoImpl;
import com.swcguild.flooringmasteryproject2.dao.ProductDao;
import com.swcguild.flooringmasteryproject2.dao.TaxDao;
import com.swcguild.flooringmasteryproject2dao.model.Order;
import com.swcguild.flooringmasteryproject2.logic.OrderFactory;

import flooringmasteryproject2.ui.FlooringUI;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DAOTest {
    OrderDao od;
    OrderFactory of;
    
   //inject "of" into "od"  ?
    
    
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
        
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        od = (OrderDaoImpl) ctx.getBean("od");
        //of= (OrderFactory) ctx.getBean("of");
       
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void daoTest() throws IOException {
        Order orderTest = new Order();

        
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
        
        
        
        ArrayList<Order> orderListTest1 = new ArrayList<>();

        Order e = of.createOrder("Wise", "OH", "Wood", 100);
        orderListTest1.add(a);

        od.writeOrders();

        ArrayList<Order> something = od.loadSpecificOrder("testfile.txt");
        Order orderResult = orderListTest1.get(0);
        orderTest = something.get(0);
        r = compare(orderTest, orderResult);
        assertTrue(r);
        
         double DELTA = 1e-15;
        
        
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
 
}
