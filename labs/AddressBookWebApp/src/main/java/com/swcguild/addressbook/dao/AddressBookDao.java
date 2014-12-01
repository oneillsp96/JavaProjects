package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.model.Address;
import java.util.List;
import java.util.Map;

public interface AddressBookDao {

   //might need to return address here?
    public void addAddress(Address address);

    public void removeAddress(int addressId);

    public void updateAddress(Address address);

    public List<Address> getAllAddresses();

    public Address getAddressById(int addressId);

    //these are similar to searchContactsByLastName and SearchContactsByCompany in example

    public List<Address> searchAddressesByLastName(String lastName);

    public List<Address> searchAddressesByCity(String city);

    public List<Address> searchAddressesByZip(String zipCode);

    //methods not similar to those used in ContactList example, figure these out after above methods are functional
    public int getNumberOfAddresses();

    //key is city
    public Map<String, List<Address>> searchAddressesByStateGroupByCity(String state);

}
