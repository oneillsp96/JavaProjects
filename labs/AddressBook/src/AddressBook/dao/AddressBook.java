package AddressBook.dao;

import AddressBook.domain.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook {

    public static final String ADDRESSBOOK_FILE = "AddressBook.txt";
    public static final String DELIMITER = "::";

    private HashMap<String, Address> addressMap = new HashMap<String, Address>();

    private static int counter = 0;

    public Address addAddress(String lastName, Address address) {

        counter++;
        return addressMap.put(lastName, address);

    }

    public Address removeAddress(String lastName) {
        counter--;
        return addressMap.remove(lastName);

    }

    public int getNumberOfAddresses() {

        return counter;
    }

    public Address[] listAllAddresses() {

        Collection<Address> values = addressMap.values();
        Address[] addressArray = values.toArray(new Address[0]);

        return addressArray;

    }

    public Address findAddress(String lastName) {

        return addressMap.get(lastName);
    }

    //write to file
    public void writeAddressBook() throws IOException {
//named the printwriter out and set it up

        PrintWriter out = new PrintWriter(new FileWriter(ADDRESSBOOK_FILE));

        Collection<Address> myAddr = addressMap.values();   //
        Iterator<Address> iter2 = myAddr.iterator();

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

    //read file 
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

            addressMap.put(currentAddress.getLastName(), currentAddress);

        }
        sc.close();

    }

}
