/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryproject.dto;
import flooringmasteryproject.logic.Math;
/**
 *
 * @author apprentice
 */
public class Product {
    Math math = new Math();
    private String product;
    private double costPerSqFt;
    private double laborPerSqFt;
    private double area;

    

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    
    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public double getLaborPerSqFt() {
        return laborPerSqFt;
    }

    public void setLaborPerSqFt(double laborPerSqFt) {
        this.laborPerSqFt = laborPerSqFt;
    }
  
}