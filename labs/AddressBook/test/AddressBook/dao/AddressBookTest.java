package AddressBook.dao;

import AddressBook.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressBookTest {

    AddressBook test;

    public AddressBookTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new AddressBook();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addressBookTest() {
        String lastName = "Oneill";
        String firstName = "Sean";
        String streetAddress = "401 Main Street";
        String city = "Akron";
        String state = "Ohio";
        String zipCode = "44024";

        Address add = new Address(lastName, firstName, streetAddress, city, state, zipCode);

        test.addAddress(lastName, add);
        Address add1 = test.findAddress(lastName);

        assertEquals(add, add1);
        int x = test.getNumberOfAddresses();
        assertEquals(x, 1);

        Address add2 = test.findAddress(lastName);
        boolean y = add.equals(add2);
        assertTrue(y);

        Address add3 = test.removeAddress(lastName);
        assertEquals(add, add3);

        String lastName1 = "Smith";

        Address abb = new Address(lastName1, firstName, streetAddress, city, state, zipCode);
        test.addAddress(lastName, add);
        test.addAddress(lastName1, abb);

        Address[] addrArray = test.listAllAddresses();
        Arrays.sort(addrArray);
        Address[] addrIn = new Address[2];
        addrIn[0] = add;
        addrIn[1] = abb;

        boolean z = Arrays.equals(addrArray, addrIn);
        assertTrue(z);

        try {
            test.writeAddressBook();
        } catch (IOException io2) {
        }

        AddressBook addBook1 = new AddressBook();

        try {
            addBook1.loadAddressBook();
            Address[] addArray = addBook1.listAllAddresses();
            Arrays.sort(addArray);
             
            //addrArray is where we wrote to, addArray is where we read from.  We're testing that what we wrote equals what we read, and assert true
            z = Arrays.equals(addrArray, addArray);
            assertTrue(z);

        } catch (FileNotFoundException fnf1) {
        }

    }

}
