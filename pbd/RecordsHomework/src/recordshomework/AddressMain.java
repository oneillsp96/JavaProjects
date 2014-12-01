
package recordshomework;

import java.net.URL;
import java.util.Scanner;

    

class AddressUnit
{
	String street;
	String city;
	String state;
	int zip;
}

public class AddressMain 
{
	public static void main(String[] args) throws Exception
	{
		URL addys = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");
		Scanner sc = new Scanner( addys.openStream() );

//scanner name refactored from fin (personal preference)
                
                
		AddressUnit uno = new AddressUnit();
		uno.street = sc.nextLine();
		uno.city   = sc.nextLine();
		uno.state  = sc.next();
		uno.zip    = sc.nextInt();
		sc.skip("\n");

		AddressUnit dos = new AddressUnit();
		dos.street = sc.nextLine();
		dos.city   = sc.nextLine();
		dos.state  = sc.next();
		dos.zip    = sc.nextInt();
		sc.skip("\n");

		AddressUnit tre = new AddressUnit();
		tre.street = sc.nextLine();
		tre.city   = sc.nextLine();
		tre.state  = sc.next();
		tre.zip    = sc.nextInt();
		sc.skip("\n");
		
                AddressUnit cuatro= new AddressUnit();
                cuatro.street=sc.nextLine();
                cuatro.city=sc.nextLine();
                cuatro.state=sc.next();
                cuatro.zip=sc.nextInt();
                sc.skip("\n");
                
                AddressUnit cinco= new AddressUnit();
                cinco.street=sc.nextLine();
                cinco.city=sc.nextLine();
                cinco.state=sc.next();
                cinco.zip=sc.nextInt();
                sc.skip("\n");
                
                AddressUnit seis= new AddressUnit();
                seis.street=sc.nextLine();
                seis.city=sc.nextLine();
                seis.state=sc.next();
                seis.zip=sc.nextInt();
                sc.skip("\n");
                
                
                
                
                
                
                
                
                
                
                
                
		sc.close();
		
		System.out.println(uno.street + ", " + uno.city + ", " + uno.state + "  " + uno.zip);
		System.out.println(dos.street + ", " + dos.city + ", " + dos.state + "  " + dos.zip);
		System.out.println(tre.street + ", " + tre.city + ", " + tre.state + "  " + tre.zip);
                System.out.println(cuatro.street + ", " + cuatro.city + ", " + cuatro.state + "  " + cuatro.zip);
                System.out.println(cinco.street + ", " + cinco.city + ", " + cinco.state + "  " + cinco.zip);
                System.out.println(seis.street + ", " + seis.city + ", " + seis.state + "  " + seis.zip);
	}
}

    
        
        

        
        