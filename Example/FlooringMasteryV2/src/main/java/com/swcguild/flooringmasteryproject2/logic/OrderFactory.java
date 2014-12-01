
package com.swcguild.flooringmasteryproject2.logic;

import com.swcguild.flooringmasteryproject2.dao.ConfigDao;
import com.swcguild.flooringmasteryproject2.dao.OrderDao;
import com.swcguild.flooringmasteryproject2.dao.OrderNumGenDao;
import com.swcguild.flooringmasteryproject2.dao.ProductDao;
import com.swcguild.flooringmasteryproject2.dao.TaxDao;
import com.swcguild.flooringmasteryproject2dao.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;


public class OrderFactory {
    
    
    
    
   
    
    public OrderFactory (TaxDao td, ProductDao pd, OrderNumGenDao ong) {

        
        this.td = td;
        this.pd = pd;
        this.ong = ong;
    }
    

    TaxDao td;
    ProductDao pd;
    Order order=new Order();
    OrderNumGenDao ong;
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
