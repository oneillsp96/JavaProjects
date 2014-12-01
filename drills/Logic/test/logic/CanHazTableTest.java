

package logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CanHazTableTest {
    
    public CanHazTableTest() {
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
    public void CanHazTable() {
    
    CanHazTable myTable= new CanHazTable();
    
    //CanHazTable(8, 9)-->yes
    //CanHazTable(9,2)-->no
    //CanHazTable(6,4)-->maybe
    
    
    int result= myTable.canHazTable(8,9);
    assertEquals(result, 2); //asserting that result is 2  
    
    result= myTable.canHazTable(9,2);
    assertEquals(result, 0); //asserting that result is 2  
    
    result= myTable.canHazTable(6,4);
    assertEquals(result, 1); //asserting that result is 2  
    
    
    
    }

    
    
    
    
    
}
