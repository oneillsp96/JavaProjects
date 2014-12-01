/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.ui;

import flooringmasteryproject.dao.ConfigDAO;
import flooringmasteryproject.dao.OrderDAO;
import flooringmasteryproject.dao.OrderNumGen;
import flooringmasteryproject.dao.ProductDAO;
import flooringmasteryproject.dao.TaxDAO;
import flooringmasteryproject.dto.Order;
import flooringmasteryproject.dto.Product;
import flooringmasteryproject.dto.Tax;
import flooringmasteryproject.logic.OrderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringUI {

    ConsoleIO io = new ConsoleIO();
    OrderFactory of = new OrderFactory();
    TaxDAO td = new TaxDAO();
    ProductDAO pcd = new ProductDAO();
    OrderDAO od = new OrderDAO();
    ConfigDAO cdao = new ConfigDAO();
    Product pc = new Product();
    Order order = new Order();
    Tax tax = new Tax();
    OrderNumGen ong = new OrderNumGen();
    boolean save;
    int counter = 0;
    boolean isStateAvailable = true;
    boolean isProductAvailable = true;
    boolean isAreaGood = true;
    boolean fileExists = true;
    Scanner sc = new Scanner(System.in);
   
    public int displayMenu() throws IOException {
        io.p("******************************************");
        io.p("*            Flooring Program            *");
        io.p("*   1. Display Orders                    *");
        io.p("*   2. Add an Order                      *");
        io.p("*   3. Edit an Order                     *");
        io.p("*   4. Remove and Order                  *");
        io.p("*   5. Save Current Work                 *");
        io.p("*   6. Quit                              *");
        io.p("******************************************");
        int choice = io.integerPromptLimits("Please select an option.");
        while (choice < 1 || choice > 6) {
            choice = io.integerPromptLimits("Please select an option.");
        }
        td.readTaxes();
        pcd.readProductCost();
        od.loadOrders();
        return choice;
    }

    public String listOrders() throws FileNotFoundException {
        String file = ".txt";
         do {   
        String fileDate = io.stringPrompt("Please enter the date of the order (yyyyMMdd)");
        file = "Order_" + fileDate + ".txt";
        File myFile = new File(file);
        if (myFile.exists()) {
        ArrayList<Order> ord = new ArrayList<>();
        ord.addAll(od.loadSpecificOrder(file));
        for (int i = 0; i < ord.size(); i++) {
            io.p("Order number---------------" + ord.get(i).getOrderNum());
            io.p("Last name------------------" + ord.get(i).getCustomerName());
            io.p("State----------------------" + ord.get(i).getState());
            io.p("Tax rate-------------------" + ord.get(i).getTaxRate());
            io.p("Product--------------------" + ord.get(i).getProduct());
            io.p("Area-----------------------" + ord.get(i).getArea());
            io.p("Material cost per sq ft----" + ord.get(i).getCostPerSqFt());
            io.p("Labor cost per sq ft-------" + ord.get(i).getLaborPerSqFt());
            io.p("Material cost--------------" + ord.get(i).getMaterialCost());
            io.p("Labor cost-----------------" + ord.get(i).getLaborCost());
            io.p("Tax------------------------" + ord.get(i).getTaxOnTotal());
            io.p("Total----------------------" + ord.get(i).getTotal());
            io.p("");
            fileExists = true;
        }
        }
        else {
            io.p("There are no orders on that date. Please try again.");
            fileExists = false;
        }
         } while (fileExists = false);
        return file;
    }

    public String isValidState(String state, String[] states) {
        do {
            for (int i = 0; i < states.length; i++) {
                if (states[i].equals(state)) {
                    counter++;
                }
            }
            if (counter == 0) {
                io.p("Sorry, but that state is not avaiilable.");
                isStateAvailable = false;
                state = io.stringPrompt("Please enter your state.");
            } else {
                isStateAvailable = true;
            }
        } while (isStateAvailable == false);
        return state;
    }

    public String isValidProduct(String product, String[] products) {

        do {
            for (int j = 0; j < products.length; j++) {
                if (products[j].equals(product)) {
                    counter++;
                }
            }
            if (counter == 0) {
                io.p("Sorry, but that product is not avaiilable.");
                isProductAvailable = false;
                product = io.stringPrompt("Please enter a product.");
            } else {
                isProductAvailable = true;
            }

        } while (isProductAvailable == false);
        return product;
    }

    public void addOrder() throws IOException {

        String customerName = io.stringPrompt("Please enter your last name.");

        io.p("Available States: ");
        String[] states = td.getStates();
        for (String st : states) {
            io.pp(st + ", ");
        }
        String state = io.stringPrompt("Please enter your state.");

        state = isValidState(state, states);

        io.p("Available Products: ");
        String[] products = pcd.getProducts();
        for (String pro : products) {
            io.pp(pro + ", ");
        }
        String product = io.stringPrompt("Please select a product.");
        counter = 0;
        
        product = isValidProduct(product, products);

        double area = io.doublePrompt("Please enter the total area of floor.");

        Order order1 = of.createOrder(customerName, state, product, area);
        od.orderList.add(order1);

        od.writeOrders();

        io.p("Your Order has been added.");

    }

    public void removeOrder() throws FileNotFoundException, IOException {
        Order orderToDelete = new Order();
        int indexOfOrder = 0;
        String file = listOrders();

        ArrayList<Order> ord = new ArrayList<>();
        ord.addAll(od.loadSpecificOrder(file));

        int orderNum = io.integerPrompt("Please enter the Number of the order you wish to delete.");
        for (Order o : ord) {
            if (o.getOrderNum() == orderNum) {
                orderToDelete = o;
                indexOfOrder = ord.indexOf(o);
            }
        }

        String answer = io.stringPrompt("Are you sure you want to delete this order (Y/N)?");

        if (answer.equals("Y") || answer.equals("y")) {
            od.orderList.remove(indexOfOrder);

            od.writeOrders();

            io.p("Order deleted.");
        } else if (answer.equals("N") || answer.equals("n")) {
            displayMenu();
        } else {
            io.p("That is not a valid option, please type (Y/N)");
            answer = io.stringPrompt("Are you sure you want to delete this order (Y/N)?");
        }

    }

    public void editOrder() throws FileNotFoundException, IOException {
        Order orderToEdit = new Order();
        int indexOfOrder = 0;
        int num = 0;
        String file = listOrders();
        ArrayList<Order> ord = new ArrayList<>();
        ord.addAll(od.loadSpecificOrder(file));
        int orderNum = io.integerPrompt("Please enter the Number of the order you wish to edit.");
        for (int i = 0; i < ord.size(); i++) {
            Order o = ord.get(i);
            if (o.getOrderNum() == orderNum) {
                num = i;
                orderToEdit = o;
            }
        }

        String name = io.stringPrompt("Please enter a last name." + " Current last name: " + orderToEdit.getCustomerName());
        io.p("Available States: ");
        String[] states = td.getStates();
        for (String st : states) {
            io.pp(st + ", ");
        }

        String state = io.stringPrompt("Please enter a state." + " Current state: " + orderToEdit.getState());
        state = isValidState(state, states);
        io.p("Available Products: ");
        String[] products = pcd.getProducts();
        for (String pro : products) {
            io.pp(pro + ", ");
        }
        String product = io.stringPrompt("Please enter a product." + " Current product: " + orderToEdit.getProduct());
        counter = 0;
        product = isValidProduct(product, products);
        String areas = io.stringPrompt("Please enter the area," + " Current area: " + orderToEdit.getArea());

        do {
            Double area1 = Double.parseDouble(areas);
            if (area1 <= 0) {
                isAreaGood = false;
                io.p("Please enter an area greater than 0.");
                areas = io.stringPrompt("Please enter the total area of floor.");
            } else {
                isAreaGood = true;
            }
        } while (isAreaGood == false);

        if (!name.equals(orderToEdit.getCustomerName()) && !name.isEmpty()) {
            orderToEdit.setCustomerName(name);
        }
        if (!state.equals(orderToEdit.getState()) && !state.isEmpty()) {
            orderToEdit.setState(state);
        }
        if (!product.equals(orderToEdit.getProduct()) && !product.isEmpty()) {
            orderToEdit.setProduct(product);
        }
        if (!areas.equals(orderToEdit.getArea()) && !areas.isEmpty()) {
            orderToEdit.setArea(Double.parseDouble(areas));
        }
        od.orderList.set(num, orderToEdit);

        od.writeOrders();

        io.p("Order updated.");

    }

    public void saveCurrentWork() throws IOException {
        
        od.writeOrders();

        io.p("Work saved.");
    }

    public void quit() throws IOException {
        od.writeOrders();
        io.p("Thank you for choosing us for your flooring needs.");
        System.exit(0);
    }

}
