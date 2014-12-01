package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//can also use @RESTController and then don't have to use response body every time???
@Controller
@RequestMapping("/rest")
public class ContactRESTController {

    private ContactListDao dao;

    @Inject
    public ContactRESTController(ContactListDao dao) {
        this.dao = dao;
    }

    //response body tells spring we're returning data
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    @ResponseBody public List<Contact> getAllContacts() {
        return dao.getAllContacts();
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    //return contact so we can bring it back and edit it or do other stuff with it
    @ResponseBody public Contact createContact(@RequestBody Contact contact){
    dao.addContact(contact);
    return contact;
    }
    
    //specify id's for contact so endpoint knows which one to operate on
     @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
     @ResponseBody public Contact getContact(@PathVariable("id") int id){
        return dao.getContactById(id);
    }
     //if method is void, don't need @ResponseBody
     @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.NO_CONTENT)
     public void putContact(@PathVariable("id") int id, @RequestBody Contact contact){
     contact.setContactId(id);
     dao.updateContact(contact);
     }
     
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE) 
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void deleteContact(@PathVariable("id") int id) {
         dao.removeContact(id);
     
     }
     
    
    
    

}
