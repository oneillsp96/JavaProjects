
package com.swcguild.contactlistjstl.dao;

import com.swcguild.contactlistjstl.model.Contact;
import java.util.ArrayList;
import java.util.List;


public class ContactDaoMockImpl implements ContactDao {

    @Override
    public List<Contact> getContacts() {
       
       Contact c1= new Contact();
       c1.setName("John Doe");
       c1.setPhone("555-1212");
       c1.setEmail("jdoe@doe.com");
       
       Contact c2=new Contact();
       c2.setName("Jane Smith");
       c2.setPhone("444-1234");
       c2.setEmail("jsmith@jsmith.com");
       
       Contact c3=new Contact();
       c3.setName("Sean O'Neill");
       c3.setPhone("403-2938");
       c3.setEmail("sean@fakeemail.com");
       
       
       
       
    List <Contact> contactList=new ArrayList<>();
    contactList.add(c1);
    contactList.add(c2);
    contactList.add(c3);
    return contactList;
    
    }
   
}
