
package com.swcguild.olympian;


public class SkiJumper {
    
    private Event event;
    
    public SkiJumper() {
event=new SkiJumpEvent();

}
    public String competeInEvent(){
    
        return event.compete();
    }
    
}
