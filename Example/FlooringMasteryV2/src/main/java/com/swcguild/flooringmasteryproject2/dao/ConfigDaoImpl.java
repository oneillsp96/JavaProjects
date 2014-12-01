
package com.swcguild.flooringmasteryproject2.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConfigDaoImpl implements ConfigDao {
    
    private String CONFIG_FILE = "testOrProd.txt";
    private String DELIMITER = ",";
    String testOrProd;

    
   

  

    @Override
    public String getTestOrProd() {
        return testOrProd;
    }

    @Override
    public void setTestOrProd(String testOrProd) {
        this.testOrProd = testOrProd;
    }

    @Override
    public void writeConfig() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(CONFIG_FILE));

       
       

      
            out.println(getTestOrProd());

            out.flush();
            out.close();
        }
        
    

    @Override
    public boolean loadConfig() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(CONFIG_FILE)));
        boolean save = true;
        String currentLine;
        String[] token;

        while (sc.hasNextLine()) {

            currentLine = sc.nextLine();
            token = currentLine.split(DELIMITER);

           
            setTestOrProd((token[0]));
            

            if (getTestOrProd().equals("test")) {
                save = false;
            }
            else {
                save = true;
            }
        }
        sc.close();
        return save;
        
    }
}
