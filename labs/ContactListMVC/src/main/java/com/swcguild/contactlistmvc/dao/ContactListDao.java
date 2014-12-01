
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;

public interface ContactListDao {
    //don't need to return contact
    public void addContact(Contact contact);
    
    public void removeContact(int contactId);
    
    public void updateContact(Contact contact);
    
    public List<Contact> getAllContacts();
    
    public Contact getContactById(int contactId);
    
    public List<Contact> searchContactByLastName (String lastName);
    
    public List<Contact> searchContactsByCompany (String company);
    
    
    
}
