//need this to print an Object!!


package recordshomework;


import java.net.URL;
import java.util.Scanner;

class Address
{
	String street;
	String city;
	String state;
	int zip;

//	//public String toString()
//	{
//		return (this.state + ", " + this.street + ", " + this.city + "  " + this.zip);
//	}
}

public class AddressToString
{
	public static void main(String[] args) throws Exception
	{
		URL addys = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");

		Address[] addybook = new Address[5];

		Scanner sc = new Scanner( addys.openStream() );

		for ( int i=0; i<5; i++ )
		{
			addybook[i] = new Address();
			addybook[i].street = sc.nextLine();
			addybook[i].city   = sc.nextLine();
			addybook[i].state  = sc.next();
			addybook[i].zip    = sc.nextInt();
			sc.skip("\n");
		}
		sc.close();
		
		for ( int i=0; i<5; i++ )
		{
			System.out.println( (i+1) + ". " + addybook[i] );           //toString automatically called when you try to print an object
		}
	}
}
