/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryproject.logic;

/**
 *
 * @author apprentice
 */
public class Math {
    public double calcTotal(double materialCost, double laborCost, double taxRate) {
        double taxOnTotal = (materialCost + laborCost) * (taxRate/100);
        double total = taxOnTotal + materialCost + laborCost;
        return total;
    }
    
    public double calcMaterialCost(double area, double materialPerSqFt) {
        double matCost = area * materialPerSqFt;
        return matCost;
    }
    
    public double calcLaborCost(double area, double laborPerSqFt) {
        double labCost = area * laborPerSqFt;
        return labCost;
    }
    
    public double calcTaxOnTotal(double taxRate, double materialCost, double laborCost) {
        double taxOnTotal = (materialCost + laborCost) * (taxRate / 100);
        return taxOnTotal;
    }
}