
package com.swcguild.flooringmasteryproject2.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    
     public static void main(String[] args) throws IOException, FileNotFoundException {
        
//         FlooringController fmp = new FlooringController();
//         fmp.run();
         
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController fmp=(FlooringController) ctx.getBean("controller");
        fmp.run();
    }
}
