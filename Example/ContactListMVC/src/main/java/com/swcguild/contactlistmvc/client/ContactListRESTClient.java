//This isn't working right now-- the purpose was to show that you can call a RESTFUL endpoint from Java/Pythen code etc, not just JQuery




package com.swcguild.contactlistmvc.client;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;   //version without 2 deprecated?
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author apprentice
 */

//REST Template  can call endpoint from java/ python etc, not just javascript
public class ContactListRESTClient {
    
    public static void main(String[] args) {
        ContactListRESTClient client = new ContactListRESTClient();
        
        Contact c = new Contact();
        c.setFirstName("John");
        c.setLastName("Doe");
        c.setCompany("Oracle");
        c.setEmail("jdoe@oracle.com");
        c.setPhone("555.1212");
        client.createContact(c);
        
        System.out.println("New ID = " + c.getContactId());
        
    }
    
    public Contact createContact(Contact contact) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());    //2?  is this valid?  It said it was deprectaed without it??
        rt.setMessageConverters(converters);
        return rt.postForObject("http://localhost:8080/ContactListMVC/spring/rest/contact", contact, Contact.class);        
    }
    
}
