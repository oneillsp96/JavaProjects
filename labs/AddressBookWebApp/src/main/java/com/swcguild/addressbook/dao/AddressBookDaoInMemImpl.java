package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.model.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookDaoInMemImpl implements AddressBookDao {

    // holds all of our Contact objects - simulates the database
    private HashMap<Integer, Address> addressMap = new HashMap<Integer, Address>();

    private static int addressIdCounter = 0;

    @Override
    public void addAddress(Address address) {

        address.setAddressId(addressIdCounter);
        addressIdCounter++;
        addressMap.put(address.getAddressId(), address);
//        return address;
    }

    @Override
    public void removeAddress(int addressId) {

        addressMap.remove(addressId);

    }

    @Override
    public void updateAddress(Address address) {
        addressMap.put(address.getAddressId(), address);

    }

    @Override
    public List<Address> getAllAddresses() {

        Collection<Address> a = addressMap.values();
        return new ArrayList(a);

    }

    @Override
    public Address getAddressById(int addressId) {

        return addressMap.get(addressId);
    }
    
    
    
    @Override
    public List<Address> searchAddressesByLastName(String lastName){
    
       return addressMap.values().stream()
                .filter(a->a.getLastName().equalsIgnoreCase(lastName))
               .collect(Collectors.toList());
                
    }

    
    
    @Override
    public List<Address> searchAddressesByCity(String city){
        return addressMap.values().stream()
                .filter(a->a.getCity().equalsIgnoreCase(city))
                  .collect(Collectors.toList());
    
    }

    @Override
    public List<Address> searchAddressesByZip(String zipCode){
    return addressMap.values().stream()
            .filter(a->a.getZipCode().equalsIgnoreCase(zipCode))
              .collect(Collectors.toList());
    }
    
    

    @Override
    public int getNumberOfAddresses() {

        return addressIdCounter;
    }
    
    @Override
    public Map<String, List<Address>> searchAddressesByStateGroupByCity(String state){
     return addressMap.values().stream()
            .filter(a->a.getState().equalsIgnoreCase(state))
             .collect(Collectors.groupingBy(a->a.getCity()));   //grouping By always returns a Map!  this is an inherent part of what it does
        
    }

}
