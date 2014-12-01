

package arrayshomework;

import java.util.Scanner;

public class ParallelArrays {
    
public static void main( String[] args )
	{
		String[] lastName = { "Manziel", "Forte", "Gore", "Charles", "Stacey" };
                Double [] gpa= {2.3, 3.2, 1.4, 3.7, 4.0};
                int [] studentId= {432, 467, 868, 451, 793};
                
                

		System.out.print("The first array is filled with the following values:\n\t");
		for ( int i=0; i<lastName.length; i++ ){
			System.out.print( lastName[i] + " " );
                }
                        
                        System.out.println("\n\n");
                
                
                System.out.println("The second array is filled with the following values:\n\t");
                
                for (int i=0; i<gpa.length; i++) {
                    System.out.print(gpa[i] + " ");
                }
                
                System.out.println();
                
                System.out.println("The third array is filled with the following values:\n\t");
                
                for (int i=0; i<studentId.length; i++) {
                    System.out.print(studentId[i] + " ");
                }
                
                Scanner sc= new Scanner(System.in);
                        
                        
                System.out.println("\nEnter a Student ID number to look up");
                int chosenId= Integer.parseInt(sc.nextLine());
                
                
                for (int i=0; i<studentId.length; i++) {
                
                    if (chosenId==studentId[i]) {
                        
                        System.out.println("Last Name: " +  lastName[i]  );
                        System.out.println("GPA: " +          gpa[i]     );
                        System.out.println("Student ID: " + studentId[i] );
                
                 }
//                    else if (chosenId!=studentId[i]) {
//                        System.out.println("You entered an invalid ID");
//                    return;
//                    
//                    }
                    
                    
                    }
                
                
                
                

	}
}
