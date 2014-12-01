
package FantasyFootballRoster.dto;


public class Player {
    
    private String lastName;
    private String firstName;
    private String quality;

    public Player(String lastName, String firstName, String quality) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.quality = quality;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    
}
