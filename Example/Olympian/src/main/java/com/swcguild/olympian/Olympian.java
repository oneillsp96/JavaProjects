
package com.swcguild.olympian;                   //now we can use spring to build ski jumper/ crosscountry skiier etc in configuration, not in code


public class Olympian {
    
    private Event event;
    private String country= "USA";   
                                       //constructor takes event
    public Olympian(Event event) {     //allow whoever constructs an olympian object (Spring) to inject event into it
    this.event=event;
    }
    
    public String competeInEvent(){
        System.out.println("Now competing for " + country + ":");
        return event.compete();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
