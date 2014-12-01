
package com.swcguild.movierentalstore;

import com.swcguild.movierentalstore.controller.MovieController;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        MovieController mc=(MovieController) ctx.getBean("controller");
        mc.run();
        
    }
    
}
