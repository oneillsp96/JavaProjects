
package com.swcguild.flooringmasteryproject2.dao;

import com.swcguild.flooringmasteryproject2dao.model.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;


public class OrderNumGenDaoImpl implements OrderNumGenDao {
    
    
    //ConfigDAO cdao = new ConfigDAO();   this is messed up so we're not using it
    private int orderNum;
    Date date1 = new Date();
    Order order = new Order();


    public String ORDER_ID = "orderNum.txt";
    public String DELIMITER = ",";
    
    @Override
    public int orderNumPlus() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_ID)));

            String number = sc.nextLine();
            orderNum = Integer.parseInt(number);
            orderNum++;
            
            return orderNum;
    }

    @Override
    public int orderNumGen()throws FileNotFoundException, IOException  {
        

        
        File myFile = new File(ORDER_ID);
        
        
        if (myFile.exists()) {
            
            Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_ID)));

            String number = sc.nextLine();
            orderNum = Integer.parseInt(number);
            orderNum++;
            PrintWriter out = new PrintWriter(new FileWriter(ORDER_ID));

        out.println(orderNum);

        out.flush();

        out.close();
    
        

        } else {
            orderNum = 1;
            PrintWriter out = new PrintWriter(new FileWriter(ORDER_ID));
       
            out.println(orderNum);
  
            out.flush();
            out.close();
        }

        return orderNum;

    }
    @Override
    public void orderNumWrite()throws IOException {
         PrintWriter out = new PrintWriter(new FileWriter(ORDER_ID));

        out.println(orderNum);

        out.flush();

        out.close();
    }
}
