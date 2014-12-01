
package com.swcguild.interestcalculatorwebapp.domain;


public class InterestCalculator {
    
 private double annualRate;
    private int numYears;
    private double totalInterest;
    private double periodInterest;
    private double updatedBalance;
    private double startBalance;
    private int period;
    private double totalBalance;

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }
   
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(double annualRate) {
        this.annualRate = annualRate;
    }

    public int getNumYears() {
        return numYears;
    }

    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public double getPeriodInterest() {
        return periodInterest;
    }

    public void setPeriodInterest(double periodInterest) {
        this.periodInterest = periodInterest;
    }

    public double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(double updatedBalance) {
        this.updatedBalance = updatedBalance;
    }

    public double getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(double startBalance) {
        this.startBalance = startBalance;
        
        //setting updated balance for calculation purposes
        this.updatedBalance = startBalance;
    }
}
