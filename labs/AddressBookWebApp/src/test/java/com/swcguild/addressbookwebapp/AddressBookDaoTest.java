//package com.swcguild.addressbookwebapp;
//
//import com.swcguild.addressbook.dao.AddressBookDao;
//import com.swcguild.addressbook.model.Address;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNull;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class AddressBookDaoTest {
//
//    private AddressBookDao dao;
//
//    private Address a1;
//    private Address a2;
//    private Address a3;
//
//    public AddressBookDaoTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        dao = (AddressBookDao) ctx.getBean("addressBookDao");
//
//        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        cleaner.execute("delete from addresses");
//
//        a1 = new Address();
//        a1.setLastName("ln");
//        a1.setFirstName("fn");
//        a1.setStreetAddress("sa");
//        a1.setCity("c");
//        a1.setState("s");
//        a1.setZipCode("z");
//
//        a2 = new Address();
//        a2.setLastName("ln");
//        a2.setFirstName("fn");
//        a2.setStreetAddress("sa");
//        a2.setCity("c");
//        a2.setState("s");
//        a2.setZipCode("z");
//
//        a3 = new Address();
//        a3.setLastName("ln");
//        a3.setFirstName("fn");
//        a3.setStreetAddress("sa");
//        a3.setCity("c");
//        a3.setState("s");
//        a3.setZipCode("z");
//
//    }
//
//    @After
//    public void tearDown() {
//
//    }
//
////    @Test
////    public void addGetDeleteAddressTest() {
////
////        dao.addAddress(a1);
////
////        Address temp = dao.getAddressById(a1.getAddressId());
////        assertEquals(a1, temp);
////
////        dao.removeAddress(a1.getAddressId());
////        assertNull(dao.getAddressById(a1.getAddressId()));
////
////    }
//
//    @Test
//    public void getAllAddressesTest() {
//
//        dao.addAddress(a1);
//        dao.addAddress(a2);
//        dao.addAddress(a3);
//
//        List<Address> aList = dao.getAllAddresses();
//        assertEquals(aList.size(), 3);
//
//    }
//
//    //test updateAddress
//    @Test
//    public void updateAddress() {
//        Address temp = dao.getAddressById(a1.getAddressId());
//
//        assertEquals(temp, a1);
//
//        temp.setCity("Akron");
//        temp.setState("OH");
//
//        //update address
//        dao.updateAddress(temp);
//
//        boolean result = temp.equals(a1);
//        assertFalse(result);
//
//    }
//
//    @Test
//    public void getByLastNameTest() {
//        //get empty list of contacts with non existant last name
//        List<Address> aList = new ArrayList<>();
//        aList = dao.searchAddressesByLastName("fake");
//        assertEquals(aList.size(), 0);
//    }
//
//    @Test
//    public void getByLastNameCityZipTest() {
//        dao.addAddress(a1);
//        dao.addAddress(a2);
//        dao.addAddress(a3);
//
////all lastnames, cities, and zips are the same so expect 3 
//        List<Address> aList = dao.searchAddressesByLastName(a1.getLastName());
//        assertEquals(aList.size(), 3);
//
//        List<Address> adList = dao.searchAddressesByCity(a2.getCity());
//        assertEquals(adList.size(), 3);
//
//        List<Address> addList = dao.searchAddressesByZip(a1.getZipCode());
//        assertEquals(addList.size(), 3);
//
//    }
//
//}
