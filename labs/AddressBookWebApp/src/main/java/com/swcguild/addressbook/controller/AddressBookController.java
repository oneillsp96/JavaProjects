package com.swcguild.addressbook.controller;

import com.swcguild.addressbook.dao.AddressBookDao;
import com.swcguild.addressbook.model.Address;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private AddressBookDao dao;

    @Inject
    public AddressBookController(AddressBookDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/addressBook", method = RequestMethod.GET)
    public String displayAddressBook(Model model) {
        List<Address> aList = dao.getAllAddresses();
        model.addAttribute("addressBook", aList);
        return "displayAddressBook";
    }

    @RequestMapping(value = "/displayNewAddressForm", method = RequestMethod.GET)
    public String displayNewAddressForm(Model model) {
        return "addAddressForm";

    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddress(Model model, HttpServletRequest req, HttpServletResponse res) {

        String lastName = req.getParameter("addressLastName");
        String firstName = req.getParameter("addressFirstName");
        String streetAddress = req.getParameter("addressStreetAddress");
        String city = req.getParameter("addressCity");
        String state = req.getParameter("addressState");
        String zipCode = req.getParameter("addressZipCode");

        Address a = new Address();
        a.setLastName(lastName);
        a.setFirstName(firstName);
        a.setStreetAddress(streetAddress);
        a.setCity(city);
        a.setState(state);
        a.setZipCode(zipCode);

        dao.addAddress(a);

        return "redirect: addressBook";  //takes user back to page that displays all addresses

    }
    //if expecting a certain request paramater, we can have spring pass it into method using annotation

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
    public String deleteAddress(@RequestParam("addressId") int id) {
        dao.removeAddress(id);
        return "redirect:addressBook";  //go back to browser, have it resubmit request to server for contactList

    }

    @RequestMapping(value = "/editAddressForm", method = RequestMethod.GET)
    public String displayEditAddressForm(@RequestParam("addressId") int id, Model model) {
        //model is so that view can display stuff in edit address form

        Address a = dao.getAddressById(id);
        model.addAttribute("address", a);
        //forward to view 

        return "editAddressForm";

    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public String updateAddress(HttpServletRequest req, HttpServletResponse res) {  //redirect to contact List to get udpadted version after editing
        Address a = new Address();

        a.setAddressId(Integer.parseInt(req.getParameter("addressId")));
        a.setLastName(req.getParameter("addressLastName"));
        a.setFirstName(req.getParameter("addressFirstName"));
        a.setStreetAddress(req.getParameter("addressStreetAddress"));
        a.setCity(req.getParameter("addressCity"));
        a.setState(req.getParameter("addressState"));
        a.setZipCode(req.getParameter("addressZipCode"));

        dao.updateAddress(a);
        return "redirect:addressBook";

    }

}
