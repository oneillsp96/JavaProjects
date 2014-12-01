
package functions.homework;

import static functions.homework.MonthNames.month_name;


import java.util.Scanner;


public class WeekdayCalculator {
    
public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to Mr. Mitchell's fantastic birth-o-meter!");
		System.out.println();
		System.out.println("All you have to do is enter your birth date, and it will");
		System.out.println("tell you the day of the week on which you were born.");
		System.out.println();
		System.out.println("Some automatic tests....");
		System.out.println("12 10 2003 => " + weekday(12,10,2003));
		System.out.println(" 2 13 1976 => " + weekday(2,13,1976));
		System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
		System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
		System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
		System.out.println("10 13 2000 => " + weekday(10,13,2000));
		System.out.println();

		System.out.println("Now it's your turn!  What's your birthday?");
		System.out.print("Birth date (mm dd yyyy): ");
		int mm = keyboard.nextInt();
		int dd = keyboard.nextInt();
		int yyyy = keyboard.nextInt();

		// put a function call for weekday() here
		System.out.println("You were born on " + weekday(mm, dd, yyyy));
	}


	public static String weekday( int mm, int dd, int yyyy )
	{
		int yy;     //number of years since 1900
                
		String date = "";

// bunch of calculations go here                             //change month offset as you wish....may need to use scanner to assign number to month offset
                             yy= yyyy-1900;
                             int total= (yy/4)+yy +dd + month_offset(mm);
                             
                             
                             if (   (is_leap(yyyy)==true) && mm==1||mm==2) {                               
                                     
                             total= (total-1);
                                 
                             }
             
                             //not sure this goes here  
                            
                             int remainder= total%7;
                             
                             
                
                
                
                
                
		date = month_name(mm) + ", " + yyyy;

		return date;
	}


	// paste your functions from MonthName, WeekdayName, and MonthOffset here
	//note - instead of copy-pasting I'm going to try to import the methods at the beginning
        
        
        
        
        
        
	public static boolean is_leap( int year )
	{
		// years which are evenly divisible by 4 are leap years,
		// but years divisible by 100 are not leap years,
		// though years divisible by 400 are leap years
		boolean result;

		if ( year%400 == 0 ) {
			result = true;
                }
		else if ( year%100 == 0 ) {
			result = false;
                }
		else if ( year%4 == 0 ) {
			result = true;
                }
                else {
			result = false;
        

                
                }
        
               //not sure this should be here
         return result;  
                
                
        }
        
   public static int month_offset( int month )
	{
		int result;
		
                
               switch (month) {

            case 1:
                result = 1;
                break;

            case 2:
                result =4;       
                break;

            case 3:
               result = 4;
                break;

            case 4:
                result = 0;
                break;
            case 5:
                result = 2;
                break;
            case 6:
                result = 5;
                break;
            case 7:
                result= 0;
                break;
            case 8:
                result = 3;
                break;
            case 9:
                result = 6;
                break;
            case 10:
                result = 1;
                break;
            case 11:
                result = 4;
                break;
            case 12:
                result = 2;
                break;
        
            default: result=-1;
                
               
		
	}
       return result;
        
        
   }     


}