

package consoleiolab;


public class ConsoleIOLab {

    
    public static void main(String[] args) {
        
        
        ConsoleIO io=new ConsoleIO();
        int a = io.integerPrompt("Please enter an integer");        //asks for integer and stores it in a
        int b = io.integerPrompt("Please enter another integer");   //asks for int and stores it in b
        int sum= a+b;                                               //stores sum of a and b
        io.displayMessage("Your sum is: " + sum);                   //calls mehod to print out whatever you type in as the parameters
                
        
        ConsoleIO io2=new ConsoleIO();
        int x=io2.intBetweenPrompt("Enter an integer between 5 and 10", 5, 10);
        io2.displayMessage("You chose " + x);
        
        
        ConsoleIO io3= new ConsoleIO();
        String s= io3.stringPrompt("Enter a String");  //asks for string and stores what user enters in s (by calling method)
        io3.displayMessage("You typed: " + s);
        
        ConsoleIO io4= new ConsoleIO();
        float f=io4.floatPrompt("Enter a float");  //prints message(to ask for float), stores float that user enters in f
        io4.displayMessage("The float you chose was: " + f);
       
        ConsoleIO io5 = new ConsoleIO();
        float fff=io5.floatBetweenPrompt("Please enter a float between 1 and 4.5", 1, 5.7f);  ///  type f because Netbeans assumes it was a double unless specified
        io5.displayMessage("You chose " + fff);
        
        
        ConsoleIO io6= new ConsoleIO();
        double myDouble=io6.doublePrompt("Enter a double");
        io6.displayMessage("The double you chose was: " + myDouble);
        
        ConsoleIO io7= new ConsoleIO();
        double bDouble=io7.floatBetweenPrompt("Enter a float between 10 and 15.8", 10, 15.8f);
        io7.displayMessage("You chose " + bDouble);
        
        
    }
    
}
