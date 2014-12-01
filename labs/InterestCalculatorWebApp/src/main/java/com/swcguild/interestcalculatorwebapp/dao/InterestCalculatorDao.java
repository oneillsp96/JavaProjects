//
//package com.swcguild.interestcalculatorwebapp.dao;
//
//import com.swcguild.interestcalculatorwebapp.domain.InterestCalculator;
//import java.text.DecimalFormat;
//import java.util.HashMap;
//
//
//public class InterestCalculatorDao {
//    
//     InterestCalculator iCalc;
//    
//    public InterestCalculatorDao(InterestCalculator iCalc) {
//        this.iCalc = iCalc;
//    }
//    
//    public void calculateInterestRate(int period) {
//        double calcPeriodInterst = 0.0;
//        switch (period) {
//            case 1: //quarterly
//                calcPeriodInterst = iCalc.getAnnualRate() / 4;
//                iCalc.setPeriod(4);
//                break;
//            case 2: //monthly
//                calcPeriodInterst = iCalc.getAnnualRate() / 12;
//                iCalc.setPeriod(12);
//                break;
//            case 3: //daily
//                calcPeriodInterst = iCalc.getAnnualRate() / 365;
//                iCalc.setPeriod(365);
//                break;
//        }
//        iCalc.setPeriodInterest(calcPeriodInterst);
//    }
//
//    public void printTotals(int year) {
//        String pattern = "#,###,###.##";
//        DecimalFormat df = new DecimalFormat(pattern);
//        System.out.println("Year: " + year + " Principal at year start: " + df.format(iCalc.getStartBalance())
//                + " Yearly interest total: " + df.format(iCalc.getTotalInterest()) + " Principle at year end: " 
//                + df.format(iCalc.getTotalBalance()));
//    }
//    
//    public HashMap<String, Double> calculateInterest() {
//        HashMap<String, Double> interestMap = new HashMap<String, Double>();
//        double calculatedBalance = this.iCalc.getUpdatedBalance();
//        double calculatedInterest = 0.0;
//        
//        
//       for (int i = 1; i <= iCalc.getNumYears(); i++) {
//           iCalc.setStartBalance(iCalc.getUpdatedBalance()); //setting the new balance for each year
//            for (int j = 1; j <= iCalc.getPeriod(); j++) {
//                calculatedBalance *= (1 + (iCalc.getPeriodInterest() / 100));
//                
//                iCalc.setUpdatedBalance(calculatedBalance); //setting updated balance with updated interest information    
//            }
//            
//            calculatedInterest = iCalc.getUpdatedBalance() - iCalc.getStartBalance();
//            iCalc.setTotalInterest(calculatedInterest);
//            iCalc.setTotalBalance(iCalc.getUpdatedBalance()); //setting final balance after period is over
//            
//            //print out results
//            printTotals(i);
//       }       
//    }
//
//}