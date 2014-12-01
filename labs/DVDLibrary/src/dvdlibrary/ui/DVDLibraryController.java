package dvdlibrary.ui;

import dvdlibrary.dao.DVDLibrary;
import dvdlibrary.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DVDLibraryController {

    ConsoleIO io = new ConsoleIO();

    DVDLibrary dvdLibrary = new DVDLibrary();

    public static void main(String[] args) {

        //instantiate ourselves- don't need this anymore since everything is in the run() method
        DVDLibraryController ui = new DVDLibraryController();
        ui.run();
    }

    public void run() {

        int mainMenu = 0;
        int userChoice;

        do {
            userChoice = displayMenu();

            switch (userChoice) {

                case 1:
                    addDVD();
                    break;

                case 2:
                    removeDVD();
                    break;
                case 3:
                    findDVD();
                    break;
                case 4:
                    findAll();
                    break;
                case 5:
                    try {
                        dvdLibrary.loadDVDLibrary();   //called method directly since it's just one line 
                    } catch (FileNotFoundException fnf1) {
                        System.out.println("Error: File not found");
                    }
                    ;
                    break;

            }

        } while (userChoice != 7);

        try {
            dvdLibrary.writeDVDLibrary();
            System.out.println("File saved");
        } catch (IOException ioe1) {
        };

    }

    public int displayMenu() {

        System.out.println("Initial Menu: Please select the operation you wish to perform:");
        System.out.println("1. Add DVD to Library");
        System.out.println("2. Delete DVD from Library");
        System.out.println("3. Find a DVD by Title");
        System.out.println("4. List All DVD's in Library");
        System.out.println("5. Load DVD from File");
        System.out.println("6. Edit info for multiple DVD's ");
        System.out.println("7. Quit and Save");

        int option = io.intBetweenPrompt("Enter Choice Now", 1, 7);

        return option;

    }

    public int goToMainMenu() {
        int n = 0;
        n = io.integerPrompt("Press 1 to go to Main Menu");
        return n;
    }

    public void addDVD() {

        String title = io.stringPrompt("Add the title");
        String releaseDate = io.stringPrompt("Enter the release date");
        String rating = io.stringPrompt("Enter the MPAA rating");
        String director = io.stringPrompt("Enter the director name");
        String studio = io.stringPrompt("Enter the studio");
        String userRatingOrNote = io.stringPrompt("Enter a rating or note about this DVD");

        DVD dvd1 = new DVD(title, releaseDate, rating, director, studio, userRatingOrNote);
        dvdLibrary.addDVD(title, dvd1);

    }

    public void removeDVD() {

        String title = io.stringPrompt("Please enter the title of the DVD you would like to remove");

        dvdLibrary.removeDVD(title);

    }

    public DVD findDVD() {

        String title = io.stringPrompt("Please enter the title of a DVD to find");

        DVD myDVD = dvdLibrary.findDVD(title);
        System.out.println("Title: " + myDVD.getTitle());
        System.out.println("Release date: " + myDVD.getReleaseDate());
        System.out.println("MPAA Rating: " + myDVD.getRating());
        System.out.println("Director: " + myDVD.getDirector());
        System.out.println("Studio: " + myDVD.getStudio());
        System.out.println("User Rating/ notes: " + myDVD.getUserRatingOrNote());
        return myDVD;
        //need to return myDVD here in order to use myDVD in edit multiple method

    }

    public void findAll() {

        DVD[] dvdArray = dvdLibrary.findAll();
        System.out.println("List of all DVD's in Library: ");

        //put dvdArray values into DVD object xxx
        for (DVD xxx : dvdArray) {
            System.out.println(xxx.getTitle() + " " + xxx.getReleaseDate() + " " + xxx.getRating() + " " + xxx.getDirector() + " " + xxx.getStudio() + " " + xxx.getUserRatingOrNote());

        }

    }

    private void edit() {

        DVD dvd1 = findDVD();

        String title = io.stringPrompt("Please Enter the Tile");
        String releaseDate = io.stringPrompt("Please Enter the Release Date");
        String rating = io.stringPrompt("Please Enter Street Address");
        String director = io.stringPrompt("Please enter the city");
        String studio = io.stringPrompt("Please enter the state");
        String userRatingOrNote = io.stringPrompt("Please enter the zip code");

        dvd1.setTitle(title);
        dvd1.setReleaseDate(releaseDate);
        dvd1.setRating(rating);
        dvd1.setDirector(director);
        dvd1.setStudio(studio);
        dvd1.setUserRatingOrNote(userRatingOrNote);

        System.out.println("DVD Info Updated");

    }

}
