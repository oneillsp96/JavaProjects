
import AddressBook2.domain.Address;
import addressbook2.dao.AddBookInterfaceImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AddressBook2Test {
    
    public AddressBook2Test() {
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
     public void testAddAddress(){
         
        AddBookInterfaceImpl implTest=new AddBookInterfaceImpl();
        
        Address add1 = new Address("Oneill", "Sean", "401 S Main St", "Akron", "OH", "44311");
        Address add2 = new Address("Doe", "Bridget", "942 Hamlet Street", "Columbus", "OH", "43201");
        Address add3 = new Address("Smith", "Dan", "10665 Fincherie Drive", "Chardon", "OH", "44024");
        
        //add 3 address objects to implTest - addressList
        
        implTest.addAddress(add1);
        implTest.addAddress(add2);
        implTest.addAddress(add3);
     
        //add same 3 address objects to addr
        List<Address> addr = new ArrayList<>();
        
        addr.add(add1);
        addr.add(add2);
        addr.add(add3);
        
        List <Address> addrByLN=new ArrayList<>();
        addrByLN.add(add1);
        
       
        //test find by last name   ---put an object into getAddr, test that there is only one object in it
        List<Address> getAddr = implTest.findAddressByLastName(add1.getLastName());                         
        assertEquals(getAddr.size(), 1);
        
        //test find by city
        List<Address> getCity=implTest.findByCity(add1.getCity());
        assertEquals(getCity.size(), 1);
        
        //test find By Zip
        List<Address> getZip=implTest.findByZip(add1.getZipCode());
        assertEquals(getZip.size(), 1);
        
     
//        //another way to test find by last name
//        boolean result = addrByLN.equals(getAddr);
//        assertTrue(result);
        
       
        //test listAllAddresses
        getAddr = implTest.listAllAddresses();  //put all addresses into getAddr
        Collections.sort(addr);                 //sort one
        Collections.sort(getAddr);              //sort the other 
        boolean result = addr.equals(getAddr);  //once both lists are sorted, we can now can compare arraylists
        assertTrue(result);
            
        
        //test get Number of addresses
        int getNum=implTest.getNumberOfAddresses();
        assertEquals(getNum, 3);
           
        
        
         //test remove
         for (int i = 0; i <addr.size(); i++) {
             implTest.removeAddress(addr.get(i));
         }
            assertEquals(implTest.getNumberOfAddresses(), 0);
            
            
            
            
           
            
            //test read and write
            
//            try {
//            implTest.writeAddressBook();
//        } catch (IOException e) {
//            System.out.println("Output Error : " + e.getMessage());
//        }
//        
//        AddressBookImpl test2 = new AddressBookImpl();
//        try {
//            test2.loadFromFile("test.txt");
//            List<Address> addrList2 = test2.listAllAddressesList();
//            Collections.sort(addrList2);
//            boolean listTest2 = addrList2.equals(getAddr);
//            assertTrue(listTest2);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: "+e.getMessage());
//        }
           
            
            
            
            
        
       
        
     
     
     
     
     
    
   //test find by state group by city
    
     
     
     
     }  
}
