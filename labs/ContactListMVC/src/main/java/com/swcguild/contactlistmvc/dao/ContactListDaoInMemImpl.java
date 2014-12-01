
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




public class ContactListDaoInMemImpl implements ContactListDao {

    private Map<Integer, Contact> contactMap=new HashMap<>();
    private static int contactIdCounter=0;
    //map and counter allow us to mimic a database 
    @Override
    public void addContact(Contact contact) {
       contact.setContactId(contactIdCounter);
       contactIdCounter++;
       contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public void removeContact(int contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {
       Collection <Contact> c=contactMap.values();
       return new ArrayList(c);
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactMap.get(contactId);
    }

    @Override  //filter on last name
    public List<Contact> searchContactByLastName(String lastName) {
        
        return contactMap.values().stream()
                .filter(c->c.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
       
    }

    @Override
    public List<Contact> searchContactsByCompany(String company) {
        return contactMap.values().stream()
                .filter(c->c.getCompany().equalsIgnoreCase(company))
                .collect(Collectors.toList());
    }
    
}
