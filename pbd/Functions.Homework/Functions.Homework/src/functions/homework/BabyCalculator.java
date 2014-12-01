
package functions.homework;

import java.util.Scanner;


public class BabyCalculator {
    
    	public static void main( String[] args ) {
		Scanner sc = new Scanner(System.in);

		
//		do
//		{
			System.out.print("> ");
			int a = sc.nextInt();
			String op = sc.next();
			int b  = sc.nextInt();
                        int c;

			if ( op.equals("+") ) {
				c = a + b;
			
                        }
                        
                        else if (op.equals("-")){
                        c=a-b;
                        }
                        
                        else if (op.equals("/")) {
                        
                        c=a/b;
                        }
                        
                        else if (op.equals("*")) {
                        c=a*b;
                        }
                                
                                
                        else{
                	System.out.println("Undefined operator: '" + op + "'.");
				c = 0;
			}

			System.out.println(c);

//		} while ( true );
	}
}


