package AddressBook.ui;

import AddressBook.dao.AddressBook;
import AddressBook.domain.Address;
import java.io.IOException;

public class AddressBookController {

    ConsoleIO io = new ConsoleIO();

    AddressBook addressBook = new AddressBook();

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
                    findAddresses();
                    break;

                case 6:
                    editAddress();
                    break;
                case 7:
                    writeAddressBook();
                    break;
                case 8:
                    loadAddressBook();

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

        int option = io.intBetweenPrompt("Enter Choice Now", 1, 8);

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

        Address addr = new Address(lastName, firstName, streetAddress, city, state, zipCode);
        addressBook.addAddress(lastName, addr);

        System.out.print("Address Added. ");

    }

    private void removeAddress() {
        String lastName = io.stringPrompt("Please Enter Last Name");

        addressBook.removeAddress(lastName);

        System.out.println("Address Removed");

    }

    private void getNumberOfAddresses() {
        System.out.print("There are " + addressBook.getNumberOfAddresses() + " in the book.");

    }

    private void listAllAddresses() {
        Address[] addressArray = addressBook.listAllAddresses();

        System.out.println("List Addresses Menu:");
        for (Address addr : addressArray) {
            System.out.println(addr.getFirstName() + " " + addr.getLastName());
            System.out.println(addr.getStreetAddress());
            System.out.println(addr.getCity());
            System.out.println(addr.getState());
            System.out.println(addr.getZipCode());
            System.out.println("");
        }

    }

    private Address findAddresses() {
        String lastName = io.stringPrompt("Please Enter Last Name of Address to Find: ");
        Address addr = addressBook.findAddress(lastName);
        System.out.println("");
        System.out.println(addr.getFirstName() + " " + addr.getLastName());
        System.out.println(addr.getStreetAddress());
        System.out.println(addr.getCity());
        System.out.println(addr.getState());
        System.out.println(addr.getZipCode());
        System.out.println("");
        return addr;
//need to return addr to use in editAddress();
    }
//calls findAddress

    private void editAddress() {

        Address addr = findAddresses();
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

    private void writeAddressBook() {

        try {
            addressBook.writeAddressBook();
        } catch (IOException ioe1) {
            System.out.println("error");
        }
    }

    private void loadAddressBook() {

        try {
            addressBook.loadAddressBook();
        } catch (IOException ioe1) {
            System.out.println("error");
        }

    }

}
