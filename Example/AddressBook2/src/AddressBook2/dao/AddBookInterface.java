
package addressbook2.dao;

import AddressBook2.domain.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface AddBookInterface {
    
    
//old methods from first version
    
    public void addAddress(Address address);
    public void removeAddress(Address address);
    public int getNumberOfAddresses();
    public List<Address> listAllAddresses();
    

//made findAddress an array since it can have multiples of the same name now
    public List<Address> findAddressByLastName(String lastName);
    public void writeAddressBook() throws IOException;
    public void loadAddressBook() throws FileNotFoundException;
             
   //new methods
             
    
    
    public List<Address> findByCity(String city);
           
    //key is city
    public Map<String, List<Address>> findByStateGroupByCity(String state);
    
    
    
    //key is zip was my zip int or string?
    public List<Address> findByZip(String zipCode);
    
    
    
  
    
    
}
