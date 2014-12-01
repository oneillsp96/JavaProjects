
package com.swcguild.flooringmasteryproject2.dao;

import com.swcguild.flooringmasteryproject2dao.model.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


public class OrderDaoImpl implements OrderDao {
    
    Date date = new Date();
    Order order = new Order();
    private ArrayList<Order> orderList = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String file = "Order_" + dateFormat.format(date) + ".txt";
    public String ORDER_FILE = file;
    public String DELIMITER = ",";
    
    
    
    
    //ConfigDAO cdao = new ConfigDAO();  our original version had bugs so we're not using it
    //OrderNumGen ong = new OrderNumGen(); this is never used

    
    @Override
    public void writeOrders() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ORDER_FILE));
        Iterator<Order> iter = orderList.iterator();

        while (iter.hasNext()) {
            Order orderX = iter.next();
        if (orderX.getCustomerName().contains(",")) {
                orderX.setCustomerName(orderX.getCustomerName().replace(",", "-"));
            }
            out.println(orderX.getOrderNum() + DELIMITER
                    + orderX.getCustomerName() + DELIMITER
                    + orderX.getState() + DELIMITER
                    + orderX.getTaxRate() + DELIMITER
                    + orderX.getProduct() + DELIMITER
                    + orderX.getArea() + DELIMITER
                    + orderX.getCostPerSqFt() + DELIMITER
                    + orderX.getLaborPerSqFt() + DELIMITER
                    + orderX.getMaterialCost() + DELIMITER
                    + orderX.getLaborCost() + DELIMITER
                    + orderX.getTaxOnTotal() + DELIMITER
                    + orderX.getTotal());

        }
        out.flush();

        out.close();
    }

    
    // DO NOT OVERRIDE - this is not set up in the interface
    
    @Override
    public ArrayList<Order> loadSpecificOrder(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));

        String currentLine;
        String[] token;
        ArrayList<Order> displayOrders = new ArrayList<>();

        while (sc.hasNextLine()) {

            currentLine = sc.nextLine();
            token = currentLine.split(DELIMITER);
            int i = 0;
            Order orderX = new Order();
            orderX.setOrderNum(Integer.parseInt(token[0]));
            orderX.setCustomerName(token[1]);
            orderX.setState(token[2]);
            orderX.setTaxRate(Double.parseDouble(token[3]));
            orderX.setProduct(token[4]);
            orderX.setArea(Double.parseDouble(token[5]));
            orderX.setCostPerSqFt(Double.parseDouble(token[6]));
            orderX.setLaborPerSqFt(Double.parseDouble(token[7]));
            orderX.setMaterialCost(Double.parseDouble(token[8]));
            orderX.setLaborCost(Double.parseDouble(token[9]));
            orderX.setTaxOnTotal(Double.parseDouble(token[10]));
            orderX.setTotal(Double.parseDouble(token[11]));

            if (orderX.getCustomerName().contains("-")) {
                orderX.setCustomerName(orderX.getCustomerName().replace("-", ","));
            }

            displayOrders.add(orderX);
            i++;

        }
        return displayOrders;

    }

    @Override
    public void loadOrders() throws FileNotFoundException, IOException {
        File myFile = new File(ORDER_FILE);
        if (myFile.exists()) {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_FILE)));
            String currentLine;
            String[] token;
            orderList.clear();

            while (sc.hasNextLine()) {

                currentLine = sc.nextLine();
                token = currentLine.split(DELIMITER);

                Order orderX = new Order();
                orderX.setOrderNum(Integer.parseInt(token[0]));
                orderX.setCustomerName(token[1]);
                orderX.setState(token[2]);
                orderX.setTaxRate(Double.parseDouble(token[3]));
                orderX.setProduct(token[4]);
                orderX.setArea(Double.parseDouble(token[5]));
                orderX.setCostPerSqFt(Double.parseDouble(token[6]));
                orderX.setLaborPerSqFt(Double.parseDouble(token[7]));
                orderX.setMaterialCost(Double.parseDouble(token[8]));
                orderX.setLaborCost(Double.parseDouble(token[9]));
                orderX.setTaxOnTotal(Double.parseDouble(token[10]));
                orderX.setTotal(Double.parseDouble(token[11]));

                if (orderX.getCustomerName().contains("-")) {
                    orderX.setCustomerName(orderX.getCustomerName().replace("-", ","));
                }
                orderList.add(orderX);
            }
            sc.close();
        } else {
            PrintWriter out = new PrintWriter(new FileWriter(ORDER_FILE));

        }

    }
//need to add these here.....before, i was adding directly to arraylist, now i need to use method in orderDao to add to arraylist

    
    @Override
    public void addOrder(Order order){
    orderList.add(order);
    }
    
    @Override
    public void removeOrder(Order order){
    orderList.remove(order);
    }
    
    @Override
    public void addOrderAtPosition (int position, Order order){
    orderList.set(position, order);
    
    }
   

    
}
