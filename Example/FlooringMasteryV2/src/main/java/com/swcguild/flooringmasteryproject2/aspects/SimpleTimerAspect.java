//"around" advice - keep in mind it's not a POJO
// can re-use this verbatim in flooringmastery, dvdlibrary etc.
package com.swcguild.flooringmasteryproject2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleTimerAspect {

    public Object timeMethod(ProceedingJoinPoint jp) {

        Object ret = null;

        //capture current time when we begin
        //call target, capture current time in ms
        //time between is time process took to execute
        //have to capture whatever might be returned from target
        try {
            long start = System.currentTimeMillis();
            ret = jp.proceed();

            long end = System.currentTimeMillis();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(jp.getSignature().getName() + " took: " + (end - start) + " Milliseconds.");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        } catch (Throwable t) {
            System.out.println("Exception in simpleTimerAspect.timemethod()");
        }

        return ret;

    }
    
    public void printIT() {
        System.out.println("++++++++++PRINT IT++++++++++");
    }

}
