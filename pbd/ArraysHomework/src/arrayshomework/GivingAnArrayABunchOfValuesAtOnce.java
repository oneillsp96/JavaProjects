

package arrayshomework;


public class GivingAnArrayABunchOfValuesAtOnce {
    
public static void main( String[] args )
	{
		String[] arr1 = { "alpha", "bravo", "charlie", "delta", "x-ray" };
                int [] arr2= {3,6,2,9,7};
                
                
                

		System.out.print("The first array is filled with the following values:\n\t");
		for ( int i=0; i<arr1.length; i++ ){
			System.out.print( arr1[i] + " " );
                }
                        
                        System.out.println();
                
                
                System.out.println("The second array is filled with the following values:\n\t");
                
                for (int i=0; i<arr2.length; i++) {
                    System.out.print(arr2[i] + " ");
                }
                
                
                

	}
}
