//Compound Interest Calculator



package labs;
import java.text.DecimalFormat;
import java.util.Scanner;

public class InterestCalculator {

    
    public static void main(String[] args) {
        
        
        
        Scanner userInput= new Scanner(System.in);
        
        String pattern= "###.##";
        DecimalFormat df= new DecimalFormat(pattern);
        
        
        
        double annualRate=0;
        double initialPrinciple=0.0;
        double periodInterest=0;
        int numYears= 0;
        
        
        
        double totalYearlyInterest;
        
        double updatedBalance;
        double startBalance;
        
        System.out.println("How much would you like to invest?");
        
        initialPrinciple=Double.parseDouble(userInput.nextLine());
        
        updatedBalance=initialPrinciple;
        
        System.out.println("What is the interest rate?");
        
        annualRate= Double.parseDouble(userInput.nextLine());
        
        System.out.println("How many years will it stay in the fund?");
        
        numYears=Integer.parseInt(userInput.nextLine());
        
        System.out.println("Choose your compounding period (Quarterly, monthly, or daily");
        
        String compoundChoice= userInput.nextLine();
        
        
        switch(compoundChoice) {
        
            case "quarterly":
                
            case "quarter":
                
                periodInterest=(annualRate/4);
                
                for (int i=1;i<numYears; i++) {
            startBalance= updatedBalance;
            
                    for (int y= 1; y<=4; y++) {
            
                    updatedBalance*= (1+(periodInterest/100));
                     
                    }
        
                        //calculating interest for the year
            
            totalYearlyInterest= updatedBalance-startBalance;
            
        System.out.println("The year is " + i);
        System.out.println("Interest earned this year was " + totalYearlyInterest);
        System.out.println("Balance at beginnining of year: " + startBalance);
        System.out.println("Balance at end of year: " + updatedBalance);
            
                    }
       
                break;
                     
        
            case "month":
            case "monthly":
                
                periodInterest=(annualRate/12);
                
                for (int i=1;i<numYears; i++) {
            startBalance= updatedBalance;
            
                    for (int y= 1; y<=12; y++) {
            
                    updatedBalance*= (1+(periodInterest/100));
                     
                    }
        
                        //calculating interest for the year
            
            totalYearlyInterest= updatedBalance-startBalance;
            
        System.out.println("The year is " + i);
        System.out.println("Interest earned this year was " + totalYearlyInterest);
        System.out.println("Balance at beginnining of year: " + startBalance);
        System.out.println("Balance at end of year: " + updatedBalance);
            
                    }
       
                break;
                
                
                case "day":
            case "daily":
                
                periodInterest=(annualRate/365);
                
                for (int i=1;i<numYears; i++) {
            startBalance= updatedBalance;
            
                    for (int y= 1; y<=365; y++) {
            
                    updatedBalance*= (1+(periodInterest/100));
                     
                    }
        
                        //calculating interest for the year
            
            totalYearlyInterest= updatedBalance-startBalance;
            
        System.out.println("The year is " + i);
        System.out.println("Interest earned this year was " + totalYearlyInterest);
        System.out.println("Balance at beginnining of year: " + startBalance);
        System.out.println("Balance at end of year: " + updatedBalance);
            
                    }
       
                break;
                
                
                
        
        
    }
    
    }

}
