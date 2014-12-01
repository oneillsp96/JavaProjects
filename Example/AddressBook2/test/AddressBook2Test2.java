
import AddressBook2.domain.Address;
import addressbook2.dao.AddBookInterfaceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressBook2Test2 {

    public AddressBook2Test2() {
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

    //test Find By State Group By City....but actually just find by state, assume it will group by city since it works in console
    @Test
    public void test2() {

        AddBookInterfaceImpl implTest=new AddBookInterfaceImpl();

        Address add1 = new Address("Oneill", "Sean", "401 S Main St", "Akron", "OH", "44311");
        Address add2 = new Address("Doe", "Bridget", "942 Hamlet Street", "Columbus", "OH", "43201");
        Address add3 = new Address("Smith", "Dan", "150 E. 12th Street", "Lansing", "MI", "44024");
        
        
        
        implTest.addAddress(add3);
               

        //rating, list of DVD's by director with that rating                         //takes state
        Map<String, List<Address>> addMap1 = implTest.findByStateGroupByCity("MI");
      //aaMap1 should now be (Lansing, List of Addresses with only add3 (a Dan Smith address object) 

        //could compare with another Map, adding (R, Titanic) but would have to sort it
        Collection myValues = addMap1.values();   //
        Iterator<List<Address>> iter = myValues.iterator();

        List<Address> dsList = new ArrayList<>();
        while (iter.hasNext()) {

            dsList = iter.next();
            //dsList should now hold just one address object, dan smith, at position 0
        }
        //get the object at position 0 and put it in Dvd titanic, then get title, which should be "Titanic"
        Address danSmith = dsList.get(0);
        

        assertEquals(danSmith.getFirstName(), "Dan");
        
        

    }
}
