
package com.swcguild.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    
    public static void main(String[] args) {
        
        //read xml file and put them into object (ctx)
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");   //starts Spring container

       //how we would do it before: 
//        SkiJumper jumper= new SkiJumper();
//        System.out.println(jumper.competeInEvent());
        
//        how we do it now
                       //cast as SkiJumper, tells compiler that whatever it hands back, treat it as a SkiJumper
//        SkiJumper jumper=(SkiJumper) ctx.getBean("superSkiJumper");
//       System.out.println(jumper.competeInEvent());
        
        
        
//        old way, without use of  DI
//        Event skiJumpEvent=new SkiJumpEvent();
//        Olympian o= new Olympian(skiJumpEvent);   // our athlete, o, is tightly coupled to an event (skiJumpEvent)
//        System.out.println(o.competeInEvent());
//        System.out.println("====");
        

        
        
        //In this step we will write code to make our application more flexible and make our athlete less tightly coupled
//to a particular event.

                               //cast Olympian
        Olympian usaSkiJumper=(Olympian) ctx.getBean("usaSkiJumper");
        usaSkiJumper.competeInEvent();
        System.out.println("===========");
        
        Olympian usaSpeedSkater=(Olympian) ctx.getBean("usaSpeedSkater");
        usaSpeedSkater.competeInEvent();
        System.out.println("==========================");
        
        Olympian canadianSpeedSkater= (Olympian) ctx.getBean("canadianSpeedSkater");
        canadianSpeedSkater.competeInEvent();
        System.out.println("===========================================");
        
        
        
        
    }
    
}
