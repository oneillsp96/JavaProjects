package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private ContactListDao dao;

    //this allows us not to have controller bean with constructor args/setters
    @Inject
    public ContactController(ContactListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/contactList", method = RequestMethod.GET)
    public String displayContactList(Model model) {
        List<Contact> cList = dao.getAllContacts();
        model.addAttribute("contactList", cList);
        return "displayContactList";
    }

    @RequestMapping(value = "/displayNewContactForm", method = RequestMethod.GET)
    public String displayNewContactForm(Model model) {
        return "addContactForm";

    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(Model model, HttpServletRequest req, HttpServletResponse res) {

        String firstName = req.getParameter("contactFirstName");
        String lastName = req.getParameter("contactLastName");
        String company = req.getParameter("contactCompany");
        String phone = req.getParameter("contactPhone");
        String email = req.getParameter("contactEmail");

        Contact c = new Contact();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setCompany(company);
        c.setPhone(phone);
        c.setEmail(email);

        dao.addContact(c);

        return "redirect: contactList";

    }

    //if expecting a certain request paramater, we can have spring pass it into method using annotation

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(@RequestParam("contactId") int id) {
        dao.removeContact(id);
        return "redirect:contactList";  //go back to browser, have it resubmit request to server for contactList

    }
    
    

    @RequestMapping(value = "/editContactForm", method = RequestMethod.GET)
    public String displayEditContactForm(@RequestParam("contactId") int id, Model model) {
        //model is so that view can display stuff in edit contact form

        Contact c = dao.getContactById(id);
        model.addAttribute("contact", c);
        //forward to view 

        return "editContactForm";

    }
    
    @RequestMapping(value="/updateContact", method=RequestMethod.POST)
    public String updateContact(@Valid Contact contact, BindingResult result, Model model){
       
//Spring form validation - @Valid and @BindingResult        
//binding result will have errors if form is not filled out properly- redirect user to try again
        try{
            if (result.hasErrors()){
            return "editContactForm";
            }
        dao.updateContact(contact);
        return "redirect: contactList";
        }catch(Exception e){
        model.addAttribute("errorMessage", e.getMessage());
        return "editContactForm";
        }
         
    }
    
    
    //this is the first method we learned before learning @model Attribute
    
//@RequestMapping(value="/updateContact", method=RequestMethod.POST)
//    public String updateContact(HttpServletRequest req, HttpServletResponse res) {  //redirect to contact List to get udpadted version after editing
//         Contact c = new Contact();
//
//        c.setContactId(Integer.parseInt(req.getParameter("contactId")));
//        c.setFirstName(req.getParameter("contactFirstName"));
//        c.setLastName(req.getParameter("contactLastName"));
//        c.setCompany(req.getParameter("contactCompany"));
//        c.setPhone(req.getParameter("contactPhone"));
//        c.setEmail(req.getParameter("contactEmail"));
//
//        dao.updateContact(c);
//        return "redirect:contactList";
//
//    }

//    //need http request/response here, so it takes different parameters//this is an enpoint where we'll submit a form to
//    public String addContact(Model model, HttpServletRequest req, HttpServletResponse res) {
//
//    }
}
