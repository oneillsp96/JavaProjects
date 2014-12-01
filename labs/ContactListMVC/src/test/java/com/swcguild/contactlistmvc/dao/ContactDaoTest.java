package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class ContactDaoTest {

    private ContactListDao dao;
    private Contact c1;
    private Contact c2;
    private Contact c3;

    public ContactDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        // dao=(ContactListDao) ctx.getBean("contactListDao");
        dao=ctx.getBean("contactListDao", ContactListDao.class);  //alternative to casting bean as ContactListDao- let Spring cast it for you

        JdbcTemplate cleaner=(JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from contacts");
        
        c1 = new Contact();
        c1.setFirstName("Initial FN");
        c1.setLastName("Initial LN");
        c1.setCompany("Company1");
        c1.setPhone("Ph1");
        c1.setEmail("Em1");

        c2 = new Contact();
        c2.setFirstName("2");
        c2.setLastName("LN2");
        c2.setCompany("Company2");
        c2.setPhone("Ph2");
        c2.setEmail("Em2");

        c3 = new Contact();
        c3.setFirstName("3");
        c3.setLastName("LN3");
        c3.setCompany("Company3");
        c3.setPhone("Ph3");
        c3.setEmail("Em3");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteContact() {

        dao.addContact(c1);

        Contact fromDb = dao.getContactById(c1.getContactId());
        assertEquals(c1, fromDb);

        //remove contact
        dao.removeContact(c1.getContactId());
        assertNull(dao.getContactById(c1.getContactId()));

    }

    @Test
    public void getAllContacts() {
        dao.addContact(c2);
        dao.addContact(c3);
        List<Contact> temp = dao.getAllContacts();
        assertEquals(temp.size(), 2);

    }
    
    @Test
    public void updateContact (){
    dao.addContact(c1);
    c1.setLastName("updatedLN");
    dao.updateContact(c1);
    Contact temp= dao.getContactById(c1.getContactId());
    assertEquals(c1, temp);
    }
    
//    @Test
//    public void getByLastNameByCompanyGetAllTest() {
//        //get empty list of contacts with non existant last name
//        List<Contact> temp = dao.searchContactByLastName("FAKE");
//        assertEquals(temp.size(), 0);
//        
//        dao.addContact(c1);
//        dao.addContact(c2);
//        dao.addContact(c3);
//        
//        //get by last name test
//        temp = dao.searchContactByLastName(c1.getLastName());
//        assertEquals(temp.size(), 1);
//        
//        temp = dao.searchContactByLastName(c2.getLastName());
//        assertEquals(temp.size(), 1);
//        
//        //get by company name test
//        temp = dao.searchContactsByCompany(c1.getCompany());
//        assertEquals(temp.size(), 2);
//        
//        temp = dao.searchContactsByCompany(c3.getCompany());
//        assertEquals(temp.size(), 1);
//        
//        //get all test
//        temp = dao.getAllContacts();
//        assertEquals(temp.size(), 3);
//    }
    
    
    
    


}
