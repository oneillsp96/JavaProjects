
package com.swcguild.olympian;


public class SpeedSkateEvent implements Event{

    @Override
    public String compete() {
        System.out.println("Skating really fast...");
        return "Speed-Skating";
    }
    
    
    
}
