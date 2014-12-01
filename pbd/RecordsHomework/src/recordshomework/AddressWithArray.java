package recordshomework;

import java.net.URL;
import java.util.Scanner;

class Addresses {

    String street;
    String city;
    String state;
    int zip;
}

public class AddressWithArray {

    public static void main(String[] args) throws Exception {
        URL addys = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");

        AddressUnit[] addybook = new AddressUnit[6];

        Scanner sc = new Scanner(addys.openStream());

        for (int i = 0; i < addybook.length; i++) {
            addybook[i] = new AddressUnit();
            addybook[i].street = sc.nextLine();
            addybook[i].city = sc.nextLine();
            addybook[i].state = sc.next();
            addybook[i].zip = sc.nextInt();
            sc.skip("\n");
        }
        sc.close();

        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + ". " + addybook[i].street + ", " + addybook[i].city + ", " + addybook[i].state + "  " + addybook[i].zip);
        }
    }
}
