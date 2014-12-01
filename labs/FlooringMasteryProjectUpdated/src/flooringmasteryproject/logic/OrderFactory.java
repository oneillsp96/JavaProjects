/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmasteryproject.logic;

import flooringmasteryproject.dao.OrderNumGen;
import flooringmasteryproject.dao.ProductDAO;
import flooringmasteryproject.dao.TaxDAO;
import flooringmasteryproject.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class OrderFactory {

    TaxDAO td = new TaxDAO();
    ProductDAO pd = new ProductDAO();
    Order order = new Order();
    OrderNumGen ong = new OrderNumGen();
    boolean isInitialized = false;

    public void init() throws FileNotFoundException {
        td.readTaxes();
        pd.readProductCost();
    }

    public Order createOrder(String customerName, String state, String product, double area) throws IOException {
         if (isInitialized == false) {
             this.init();
         }
        Order order1 = new Order();
        order1.setOrderNum(ong.orderNumGen());
        order1.setCustomerName(customerName);
        order1.setState(state);
        order1.setTaxRate(td.taxRate(state));
        order1.setProduct(product);
        order1.setArea(area);
        order1.setCostPerSqFt(pd.matCost(product));
        order1.setLaborPerSqFt(pd.labCost(product));
        order1.setMaterialCost(calcMaterialCost(area, order1.getCostPerSqFt()));
        order1.setLaborCost(calcLaborCost(area, order1.getLaborPerSqFt()));
        order1.setTaxOnTotal(calcTaxOnTotal(order1.getTaxRate(), order1.getMaterialCost(), order1.getLaborCost()));
        order1.setTotal(calcTotal(order1.getMaterialCost(), order1.getLaborCost(), order1.getTaxRate()));

        return order1;

    }

    private double calcTotal(double materialCost, double laborCost, double taxRate) {
        double taxOnTotal = (materialCost + laborCost) * (taxRate / 100);
        double total = taxOnTotal + materialCost + laborCost;
        return total;
    }

    private double calcMaterialCost(double area, double materialPerSqFt) {
        double matCost = area * materialPerSqFt;
        return matCost;
    }

    double calcLaborCost(double area, double laborPerSqFt) {
        double labCost = area * laborPerSqFt;
        return labCost;
    }

    private double calcTaxOnTotal(double taxRate, double materialCost, double laborCost) {
        double taxOnTotal = (materialCost + laborCost) * (taxRate / 100);
        return taxOnTotal;
    }

}
