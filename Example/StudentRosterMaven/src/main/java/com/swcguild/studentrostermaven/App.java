
package com.swcguild.studentrostermaven;

import com.swcguild.studentrostermaven.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
                StudentController controller=(StudentController) ctx.getBean("controller");
                controller.run();
        
    }
}
