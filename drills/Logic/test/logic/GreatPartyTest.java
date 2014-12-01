

package logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GreatPartyTest {
    
    public GreatPartyTest() {
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

    @Test //marker
    public void greatPartyTest() {
    
    GreatParty myParty= new GreatParty();
    
    //greatParty(30, false) -->false
    boolean result=myParty.greatParty(30, false);
    assertFalse(result);
    
    result=myParty.greatParty(50, false);
    assertTrue(result);
    
    result =myParty.greatParty(70, true);
    assertTrue(result);
            
            
    }
}
