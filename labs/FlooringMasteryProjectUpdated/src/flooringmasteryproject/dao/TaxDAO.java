/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryproject.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import flooringmasteryproject.dto.Tax;
import java.util.Set;
/**
 *
 * @author apprentice
 */
public class TaxDAO {
    private String DELIMITER = ",";
    private String DATA_TAX_FILE = "datataxes.txt";
    public HashMap<String, Double> taxMap = new HashMap<>();

    public double taxRate(String state) {
        double rate = taxMap.get(state);
        return rate;
    }
    public String[] getStates() {
        Set<String> keySet = taxMap.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
    
   

    public void readTaxes()throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DATA_TAX_FILE)));
        
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Tax currentTax = new Tax();
            currentTax.setState(currentTokens[0]);
            currentTax.setTaxRate(Double.parseDouble(currentTokens[1]));
            
            taxMap.put(currentTax.getState(), currentTax.getTaxRate());
        }
        sc.close();
    }

    }
