//"around" advice - keep in mind it's not a POJO
// can re-use this verbatim in flooringmastery, dvdlibrary etc.


package com.swcguild.serverinventory;

//import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleTimerAspect {

    public Object timeMethod(ProceedingJoinPoint jp) {

        Object ret = null;
       
        //capture current time when we begin
        //call target, capture current time in ms
        //time between is 
        
        //have to capture whatever might be returned from target
        
        
        try{
            long start= System.currentTimeMillis();
            ret=jp.proceed();
            
            long end= System.currentTimeMillis();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(jp.getSignature().getName() + " took: " + (end-start) + " Milliseconds.");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       
        
        }catch(Throwable t){
            System.out.println("Exception in simpleTimerAspect.timemethod()");
        }
         
        return ret;

    }

}
