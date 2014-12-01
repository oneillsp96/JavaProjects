
package com.swcguild.serverinventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {
    
     public static void main(String[] args) {
        //first make it so it doesn't depend on other classes, like lines 16-18
        
         
         //make spring run lines 17-19
         
//        ServerInventoryController sic = new ServerInventoryController();
//        sic.setDao(new ServerDaoMockImpl());
//        sic.setIo(new IOConsoleImpl());
         
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        ServerInventoryController sic=(ServerInventoryController) ctx.getBean("controller");
        sic.run();
    }
    
}
