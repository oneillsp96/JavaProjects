

package AddressBook.ui;

import java.util.Scanner;

//class now contains a scanner---delegated Scanner from 
public class ConsoleIO {
    
    private Scanner sc= new Scanner(System.in);
    
    
    
    public int integerPrompt (String message) {
    
        int input=0;
        boolean isInvalidInput=true;
       
        do{                                                //error handling
            try{
        System.out.println(message);
        String inputString= (sc.nextLine());
        input= Integer.parseInt(inputString); 
        isInvalidInput=false;
            }catch(NumberFormatException nfe){
            System.out.println("You must input an integer");
        }    
        } while(isInvalidInput);
        
            return input;
        }
    
    
    
    public int intBetweenPrompt (String message, int min, int max) {
        System.out.println(message);
        int input=Integer.parseInt(sc.nextLine()); 
        
        while(input<min || input>max) {
                
            System.out.println("Try again");
            input=Integer.parseInt(sc.nextLine());
        }
        
    return input;
    
    }
    
    public String stringPrompt (String message) {
    
        System.out.println(message);
        String wordTyped=sc.nextLine();
        
        return wordTyped;
    
    }
    
    public float floatPrompt (String message){
    
        System.out.println(message);
        float floatTyped=Float.parseFloat(sc.nextLine());
        
        return floatTyped;
    }
    
    
    public float floatBetweenPrompt(String message, float min, float max) {
    
        System.out.println(message);
        float fb=Float.parseFloat(sc.nextLine());
        
        while (fb<min || fb > max) {
            
            System.out.println("Try again");
            fb=Float.parseFloat(sc.nextLine());
        
        }
    
    return fb;
    }
    
    
    public double doublePrompt(String message) {
    
        System.out.println(message);
        double d= Double.parseDouble(sc.nextLine());
        return d;
    
    }
    
    public double doubleBetweenPrompt(String message, double min, double max){
    
        System.out.println(message);
        double fInput=Double.parseDouble(sc.nextLine());
        
        while (fInput>max || fInput<min) {
            System.out.println("Try again");
        }
        
    return fInput;
    
    
    }
    
    
    
    
    
    
    
    //USE THIS EVERY TIME YOU WANT TO DISPLAY FINAL MESSAGE
    public void displayMessage(String message) {
    
        System.out.println(message);
    }
    
    
}
