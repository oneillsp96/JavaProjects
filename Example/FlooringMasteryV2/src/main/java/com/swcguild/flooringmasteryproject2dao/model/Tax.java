/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryproject2dao.model;

//import flooringmasteryproject.dao.TaxDAO;      Do I need this????  Don't think so (5:00 PM, 9-25-2014)
//import flooringmasteryproject2.logic.Math;

/**
 *
 * @author apprentice
 */
public class Tax {
  //  TaxDAO td = new TaxDAO();
   // Math math = new Math();
    private String state;
    private double taxRate;

    

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }



}