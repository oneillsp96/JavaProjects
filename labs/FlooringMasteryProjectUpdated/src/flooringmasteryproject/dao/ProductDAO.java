/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryproject.dao;

import flooringmasteryproject.dto.Order;
import flooringmasteryproject.dto.Product;
import flooringmasteryproject.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class ProductDAO {
    Product pc = new Product();
    private String PRODUCT_FILE = "productData.txt";
    private String DELIMITER = ",";
    public HashMap<String, Product> costMap = new HashMap<>();
    
     public String[] getProducts() {
        Set<String> keySet = costMap.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
     
     public double matCost(String product) {
        double matCost = costMap.get(product).getCostPerSqFt();
        return matCost;
    }
     
     public double labCost(String product) {
        double labCost = costMap.get(product).getLaborPerSqFt();
        return labCost;
    }
    
   
    
     public void readProductCost()throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Product pc = new Product();
            pc.setProduct(currentTokens[0]);
            pc.setCostPerSqFt(Double.parseDouble(currentTokens[1]));
            pc.setLaborPerSqFt(Double.parseDouble(currentTokens[2]));

            costMap.put(pc.getProduct(), pc);
        }
        sc.close();
    }
}
