/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import flooringmastery.ui.FlooringUI;
import flooringmasteryproject.dao.OrderDAO;
import flooringmasteryproject.logic.OrderFactory;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 *
 * @author apprentice
 */
public class FlooringController {

    OrderDAO od = new OrderDAO();
    FlooringUI fui = new FlooringUI();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FlooringController fmp = new FlooringController();
        fmp.run();
    }

    public void run() throws IOException {
        
        boolean goOn = true;
        int choice = fui.displayMenu();
        
         do {
            switch (choice) {
               
                case 1:
                    fui.listOrders();
                    run();
                    break;
                case 2:                  
                    fui.addOrder();
                   run();
                    break;
                case 3:
                    fui.editOrder();
                    run();
                    break;
                case 4:
                    fui.removeOrder();
                    run();
                    break;
                case 5:
                    fui.saveCurrentWork();
                    run();
                    break;
                case 6:
                    fui.quit();                  
                }
            } while (choice != 6);
            
        
        
    }

   
}