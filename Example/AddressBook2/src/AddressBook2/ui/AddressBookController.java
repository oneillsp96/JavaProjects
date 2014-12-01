package AddressBook2.ui;

import AddressBook2.domain.Address;
import addressbook2.dao.AddBookInterfaceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressBookController {

    ConsoleIO io = new ConsoleIO();

    //  AddressBook addressBook = new AddressBook();
    AddBookInterfaceImpl impl = new AddBookInterfaceImpl();
    Address addr;

    public static void main(String[] args) {

        //need to "instantiate yourself" to use non-static methods
        AddressBookController ui = new AddressBookController();
        ui.run();
    }

    public void run() {

        int mainMenu = 0;
        do {
            int userChoice = displayMenu();

            switch (userChoice) {

                case 1:
                    addAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    getNumberOfAddresses();
                    break;
                case 4:
                    listAllAddresses();
                    break;
                case 5:
                    findAddressesByLastName();
                    break;
                case 6:
                    editAddress();
                    break;
                case 7:
                    writeAddressBook();
                    break;
                case 8:
                    loadAddressBook();
                    break;
                case 9:
                    findByCity();
                    break;
                case 10:
                    findByZip();
                case 11:
                    findByStateGroupByCity();
                    break;

            }
            mainMenu = goToMainMenu();
        } while (mainMenu == 1);

    }

    public int displayMenu() {

        System.out.println("Initial Menu: Please select the operation you wish to perform:");
        System.out.println("1. Add Address");
        System.out.println("2. Delete Address");
        System.out.println("3. Get Number of Addresses");
        System.out.println("4. List All Addresses");
        System.out.println("5. Find Address by Last Name");
        System.out.println("6. Edit Address");
        System.out.println("7. Save to File");
        System.out.println("8. Load from File");
        System.out.println("9. Find Address by City");
        System.out.println("10.  Find Address by Zip Code");
        System.out.println("11. Find Address by State");

        int option = io.intBetweenPrompt("Enter Choice Now", 1, 11);

        return option;

    }

    private int goToMainMenu() {
        int n = 0;
        n = io.integerPrompt("Press 1 to go to Main Menu");
        return n;
    }

    private void addAddress() {
        String firstName = io.stringPrompt("Please Enter First Name");
        String lastName = io.stringPrompt("Please Enter Last Name");
        String streetAddress = io.stringPrompt("Please Enter Street Address");
        String city = io.stringPrompt("Please enter the city");
        String state = io.stringPrompt("Please enter the state");
        String zipCode = io.stringPrompt("Please enter the zip code");

        addr = new Address(lastName, firstName, streetAddress, city, state, zipCode);

        impl.addAddress(addr);

        //old way with HashMap -----addressBook.addAddress(lastName, addr);
        System.out.print("Address Added. ");

    }

    private void removeAddress() {
        String lastName = io.stringPrompt("Please Enter Last Name ");

        List<Address> addyList = new ArrayList<>();
        addyList = impl.findAddressByLastName(lastName);

        //dispaly all addresses that come back
        //use index 1. 2. 3. 4. "please enter address to remove
        //if they choose 1, addyList.remove(1)
        if (addyList.size() > 1) {

          
                for (int i = 0; i < addyList.size(); i++) {
                    
                    Address addr=addyList.get(i);
                    System.out.println("Number: " + i);
                    System.out.println(addr.getFirstName() + " " + addr.getLastName());
                    System.out.println(addr.getStreetAddress());
                    System.out.println(addr.getCity());
                    System.out.println(addr.getState());
                    System.out.println(addr.getZipCode());
                    System.out.println("");
                }

            
            //min is 0, max is size of list minus 1
            int userInput = io.intBetweenPrompt("Please enter the number of the address you would like to remove", 0, (addyList.size() - 1));

            impl.removeAddress(addyList.get(userInput));    //this will remove all addresses with this last name

        } else if (addyList.size() == 1) {
            addyList.remove(addyList.get(0));
        }
        System.out.println("Address Removed");
    }

    private void getNumberOfAddresses() {
        System.out.print("There are " + impl.getNumberOfAddresses() + " entries in the book.");

    }

    private void listAllAddresses() {
        // old way with normal array -----   Address[] addressArray = addressBook.listAllAddresses();
        List<Address> addyList = new ArrayList<>();
        addyList = impl.listAllAddresses();

        System.out.println("List Addresses Menu:");
        for (Address addr : addyList) {
            System.out.println(addr.getFirstName() + " " + addr.getLastName());
            System.out.println(addr.getStreetAddress());
            System.out.println(addr.getCity());
            System.out.println(addr.getState());
            System.out.println(addr.getZipCode());
            System.out.println("");
        }

    }

    private List<Address> findAddressesByLastName() {
        String lastName = io.stringPrompt("Please Enter Last Name of Address to Find: ");

        List<Address> addyList = new ArrayList<>();
        addyList = impl.findAddressByLastName(lastName);

        for (int i = 0; i < addyList.size(); i++) {

            Address addr = addyList.get(i);
            System.out.println(addr.getFirstName());
            System.out.println(addr.getFirstName() + " " + addr.getLastName());
            System.out.println(addr.getStreetAddress());
            System.out.println(addr.getCity());
            System.out.println(addr.getState());
            System.out.println(addr.getZipCode());
            System.out.println("");

        }
        return addyList;
    }

    //old way ---Address addr = addressBook.findAddress(lastName);
//       
//need to return addr to use in editAddress();
//calls findAddress
    
    private void editAddress() {

        List<Address> addyList = new ArrayList<>();
        addyList = findAddressesByLastName();

        for (Address addr : addyList) {
            String firstName = io.stringPrompt("Please Enter First Name");
            String streetAddress = io.stringPrompt("Please Enter Street Address");
            String city = io.stringPrompt("Please enter the city");
            String state = io.stringPrompt("Please enter the state");
            String zipCode = io.stringPrompt("Please enter the zip code");

            addr.setFirstName(firstName);
            addr.setStreetAddress(streetAddress);
            addr.setCity(city);
            addr.setState(state);
            addr.setZipCode(zipCode);
            System.out.println("Address updated.");

        }
    }

    private void writeAddressBook() {

        try {
            impl.writeAddressBook();
            // old way---addressBook.writeAddressBook();
        } catch (IOException ioe1) {
            System.out.println("error");
        }
    }

    private void loadAddressBook() {

        try {
            impl.loadAddressBook();
            // old way---addressBook.loadAddressBook();
        } catch (IOException ioe1) {
            System.out.println("error");
        }

    }

    private void findByCity() {

        String city = io.stringPrompt("Please Enter City of Address to Find: ");

        List<Address> addyList = new ArrayList<>();
        addyList = impl.findByCity(city);

        for (int i = 0; i < addyList.size(); i++) {

            Address addr = addyList.get(i);
            System.out.println(addr.getFirstName());
            System.out.println(addr.getFirstName() + " " + addr.getLastName());
            System.out.println(addr.getStreetAddress());
            System.out.println(addr.getCity());
            System.out.println(addr.getState());
            System.out.println(addr.getZipCode());
            System.out.println("");

        }

    }

    private void findByZip() {

        String zipCode = io.stringPrompt("Please Enter Zip Code of Address to Find: ");

        List<Address> addyList = new ArrayList<>();
        addyList = impl.findByZip(zipCode);

        for (int i = 0; i < addyList.size(); i++) {

            Address addr = addyList.get(i);
            System.out.println(addr.getFirstName() + " " + addr.getLastName());
            System.out.println(addr.getStreetAddress());
            System.out.println(addr.getCity());
            System.out.println(addr.getState());
            System.out.println(addr.getZipCode());
            System.out.println("");

        }

    }

    private void findByStateGroupByCity() {

        String state = io.stringPrompt("Please Enter the State of Address to Find: ");

        //string =city
        Map<String, List<Address>> addyMap = new HashMap<>();
        addyMap = impl.findByStateGroupByCity(state);

        //addyMap is a map where keys are cities, values are lists of addresses
        Set myKeys = addyMap.keySet();
        Iterator<String> iter = myKeys.iterator();
        
        
        while (iter.hasNext()) {
        
            String city = iter.next();
            System.out.println("");
            System.out.println("City : " + city);
            
            List <Address> addyList = addyMap.get(city);
            for (Address addr : addyList) {
                System.out.println("");

                System.out.println(addr.getFirstName() + " " + addr.getLastName());
                System.out.println(addr.getStreetAddress());
                System.out.println(addr.getCity());
                System.out.println(addr.getState());
                System.out.println(addr.getZipCode());
                System.out.println("");
//            
            }

        }

        //get keys out
    }

}
