package FantasyFootballRoster.ui;

import FantasyFootballRoster.dto.Player;
import fantasyfootballroster.dao.FantasyFootballRoster;

public class FantasyFootballRosterController {

    FantasyFootballRoster myRoster = new FantasyFootballRoster();

    ConsoleIO io = new ConsoleIO();

    public static void main(String[] args) {

        FantasyFootballRosterController ui = new FantasyFootballRosterController();
        ui.run();
    }

    int mainMenu=0;
    public void run() {

        

        do { int userChoice = displayMenu();
            
            switch (userChoice) {

                case 1:
                     addPlayer();
                    break;

                case 2:
                    removePlayer();
                    break;

                case 3:
                    findPlayer();
                    break;
            }
            
             mainMenu=goToMenu();
        } while (mainMenu==1);
        
        
    
        
        
    } //closes run() method      

    private int goToMenu() {
        int n = 0;
        n = io.integerPrompt("Enter 1 to return to main menu");

        return n;
    }

    private int displayMenu() {

        System.out.println("Main Menu- Choose an Option");
        System.out.println("1. Add Player");
        System.out.println("2. Remove Player");
        System.out.println("3. Find Player by Last Name");

        int returnedVal = (io.intBetweenPrompt("Enter choice now", 1, 3));
        return returnedVal;

    }

    private void addPlayer() {
        String lastName = io.stringPrompt("Enter Last Name");
        String firstName = io.stringPrompt("Enter First Name");
        String quality = io.stringPrompt("Enter quality rating");

        Player myPlayer = new Player(lastName, firstName, quality);
        myRoster.addPlayer(lastName, myPlayer);

    }

    private void removePlayer() {

        String lastName = io.stringPrompt("Enter the last name of the player you wish to remove");
        myRoster.removePlayer(lastName);

        System.out.println("Player removed.");

    }

    private void findPlayer() {

        String lastName = io.stringPrompt("Enter player's last name to find player");
        Player myPlayer=myRoster.findPlayer(lastName);
        
        System.out.println(myPlayer.getFirstName());
        System.out.println(myPlayer.getLastName());
        System.out.println(myPlayer.getQuality());
        
        
        
        

    }

} //close class
