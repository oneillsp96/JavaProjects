
package addressbook2.dao;

import AddressBook2.domain.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AddBookInterfaceImpl implements AddBookInterface {
    
    
    public static final String ADDRESSBOOK_FILE = "AddressBook.txt";
    public static final String DELIMITER = "::";
    //private static int counter = 0; don't need this because arraylist will tell us size

    private List<Address> addressList = new ArrayList<Address>();


    
    @Override
    public void addAddress(Address address) {
        
        
     addressList.add(address);

    }

    @Override
    public void removeAddress(Address address) {
       
         addressList.remove(address);
        
    }

    @Override
    public int getNumberOfAddresses() {
       
        return addressList.size();
        
    }
    
    //take addresses, turn it into an array of addresses, return it

    @Override
    public List<Address> listAllAddresses() {
        
       return addressList;
               
    }

    @Override
    public List<Address> findAddressByLastName(String lastName) {
       
        return addressList.stream()
                .filter(a ->a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        
        
        
    }

    @Override
    public void writeAddressBook() throws IOException {
         PrintWriter out = new PrintWriter(new FileWriter(ADDRESSBOOK_FILE));

        
        Iterator<Address> iter2 = addressList.iterator();

        Address currentAddress;
        while (iter2.hasNext()) {

            currentAddress = iter2.next();

            out.println(currentAddress.getLastName() + DELIMITER + currentAddress.getFirstName()
                    + DELIMITER + currentAddress.getStreetAddress() + DELIMITER + currentAddress.getCity() + DELIMITER
                    + currentAddress.getState() + DELIMITER + currentAddress.getZipCode());
            out.flush();   //force write
        }

        out.close();
       
    }

    @Override
    public void loadAddressBook() throws FileNotFoundException {
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESSBOOK_FILE)));

        //"bookkeeping"
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            //get the line and put it into current line
            currentLine = sc.nextLine();

            //tells it to split string on delimiter(:: in this case)
            currentTokens = currentLine.split(DELIMITER);

            Address currentAddress = new Address(currentTokens[0], currentTokens[1], currentTokens[2], currentTokens[3], currentTokens[4], currentTokens[5]);

            addressList.add(currentAddress);
            
           //old way with HashMap---- addressMap.put(currentAddress.getLastName(), currentAddress);

        }
        sc.close();

    }
    

    @Override

    public List<Address> findByCity(String city) {
        
        return addressList.stream()
                .filter(a->a.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
    
    
    @Override
    
                //String is city ---first filters by state   
    public Map<String, List<Address>> findByStateGroupByCity(String state) {
        
       
        
        return addressList.stream()
                .filter(a->a.getState().equalsIgnoreCase(state))
                .collect(Collectors.groupingBy(a->a.getCity()));   //grouping By always returns a Map!  this is an inherent part of what it does
        
        
    }

    
   
    
    @Override
    public List<Address> findByZip(String zipCode) {
        
        
         return addressList.stream()                                   //stream of addresses comes out
                .filter(a->a.getZipCode().equals(zipCode))   //we take the ones that have the same zip code as zip code handed in to method
                .collect(Collectors.toList());                         //collect address objects with zip codes that match and return them as a list
        
    }

}
   
    
    
    
        
        
        
        
        
       