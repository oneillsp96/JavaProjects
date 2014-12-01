package com.swcguild.dvdlibrary.ui;


import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrarydao.model.Dvd;
import com.swcguild.dvdlibraryv3.dao.DvdLibraryDaoImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DVDLibraryController {
    DvdLibraryDao dao;
    public DVDLibraryController(DvdLibraryDao library){
        this.dao=dao;
    }
    
    DvdLibraryDaoImpl impl= new DvdLibraryDaoImpl();  //still need this to get ArrayList from DvdLibraryDaoImpl
     
    Dvd dvd;
    ConsoleIO io = new ConsoleIO();

    // DVDLibrary dvdLibrary = new DVDLibrary();
    public static void main(String[] args) {
        
//        DvdLibraryDaoImpl impl= new DvdLibraryDaoImpl();
//
//        //we changed controller so that whoever instantiates impl can change stuff??
//        
        //we replaced this with the code on line 41 (we let Spring create the controller object)
        //DVDLibraryController controller = new DVDLibraryController(impl);
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDLibraryController controller = (DVDLibraryController) ctx.getBean("controller");

//impl =(DvdLibraryDaoImpl) ctx.getBean("  ");  
        controller.run();
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
                    findDvdByTitle();
                    break;
                case 4:
                    listAll();
                    break;
                case 5:
                    try {
                        loadFromFile();
                    } catch (FileNotFoundException fnf1) {
                        System.out.println("Error: File not found");
                    }
                    ;
                    break;
                case 6:
                    edit();
                    break;
                case 7:
                    getByRating();
                    break;
                case 8:
                    getByStudio();
                    break;
                case 9:
                    getAverageAge();
                    break;
                case 10: 
                    getByDirectorGroupByRating();
                    break;
                case 11:
                    getReleasesInLastNYears();
                    break;
                
            }

        } while (userChoice != 12);

        try {
            writeToFile();
            System.out.println("File saved");
        } catch (IOException ioe1) {
        };

    }

    public int displayMenu() {

        System.out.println("Initial Menu: Please select the operation you wish to perform:");
        System.out.println("1. Add DVD to Library");
        System.out.println("2. Remove DVD from Library");
        System.out.println("3. Find a DVD by Title");
        System.out.println("4. List All DVD's in Library");
        System.out.println("5. Load DVD from File");
        System.out.println("6. Edit info for multiple DVD's ");
        System.out.println("7. Get DVD's by Rating");
        System.out.println("8. Get DVD's by Studio");
        System.out.println("9. Get average age of all DVD's in Library");
        System.out.println("10. Get DVD's by Director (grouped by rating)");
        System.out.println("11. Get list of DVD's released in last N years");

       
        System.out.println("12. Quit and Save");

        int option = io.intBetweenPrompt("Enter Choice Now", 1, 12);

        return option;
    }

    public int goToMainMenu() {
        int n = 0;
        n = io.integerPrompt("Press 1 to go to Main Menu");
        return n;
    }


    private void addDVD() {

        String title = io.stringPrompt("Add the title");
        String releaseDate = io.stringPrompt("Enter the release date (YY-MM-DD): ");
        String rating = io.stringPrompt("Enter the MPAA rating");
        String director = io.stringPrompt("Enter the director name");
        String studio = io.stringPrompt("Enter the studio");
        String note = io.stringPrompt("Enter a rating or note about this DVD");

        Dvd dvd1 = new Dvd();  // (title, releaseDate, rating, director, studio, note);
        dvd1.setTitle(title);
        dvd1.setReleaseDate(LocalDate.parse(releaseDate));
        dvd1.setMpaaRating(rating);
        dvd1.setDirector(director);
        dvd1.setStudio(studio);
        dvd1.setNote(note);

        impl.add(dvd1);

        //old way with HashMap---- dvdLibrary.addDVD(title, dvd1);
    }

    private List<Dvd> findDvdByTitle() {
        String dvd = io.stringPrompt("Please enter the title of the DVD to find");

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = impl.getByTitle(dvd);

        for (int i = 0; i < dvdList.size(); i++) {

            Dvd dvd1 = dvdList.get(i);
            System.out.println(dvd1.getTitle());
            System.out.println(dvd1.getReleaseDate());
            System.out.println(dvd1.getMpaaRating());
            System.out.println(dvd1.getDirector());
            System.out.println(dvd1.getStudio());
            System.out.println(dvd1.getNote());
            System.out.println("");

        }
        return dvdList;
    }

    private void removeDVD() {

        String dvd = io.stringPrompt("Please Enter Title of DVD to remove ");

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = impl.getByTitle(dvd);

        //display all addresses that come back
        //use index 1. 2. 3. 4. "please enter address to remove
        //if they choose 1, addyList.remove(1)
        if (dvdList.size() > 1) {

           
                for (int i = 0; i < dvdList.size(); i++) {
                    
                    Dvd dvd1=dvdList.get(i);
                    System.out.println("Number: " + i);

                    System.out.println(dvd1.getTitle());
                    System.out.println(dvd1.getReleaseDate());
                    System.out.println(dvd1.getMpaaRating());
                    System.out.println(dvd1.getDirector());
                    System.out.println(dvd1.getStudio());
                    System.out.println(dvd1.getNote());
                    System.out.println("");

                

            }
            //min is 0, max is size of list minus 1
            int userInput = io.intBetweenPrompt("Please enter the number of the DVD you would like to remove", 0, (dvdList.size() - 1));

            impl.remove(dvdList.get(userInput));

        } else if (dvdList.size() == 1) {
            dvdList.remove(dvdList.get(0));
        }
        System.out.println("Address Removed");

    }

    private void listAll() {

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = impl.listAll();

        System.out.println("List DVD's Menu:");
        for (Dvd dvd1 : dvdList) {
            System.out.println(dvd1.getTitle());
            System.out.println(dvd1.getReleaseDate());
            System.out.println(dvd1.getMpaaRating());
            System.out.println(dvd1.getDirector());
            System.out.println(dvd1.getStudio());
            System.out.println(dvd1.getNote());
            System.out.println("");
        }

    }

    private void edit() {

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = findDvdByTitle();
        for (Dvd dvd1 : dvdList) {

            String title = io.stringPrompt("Please Enter the Title");
            String releaseDate = io.stringPrompt("Please Enter the Release Date");
            String mpaaRating = io.stringPrompt("Please Enter Street Address");
            String director = io.stringPrompt("Please enter the city");
            String studio = io.stringPrompt("Please enter the state");
            String note = io.stringPrompt("Please enter the zip code");

            dvd1.setTitle(title);
            dvd1.setReleaseDate(LocalDate.parse(releaseDate));
            dvd1.setMpaaRating(mpaaRating);
            dvd1.setDirector(director);
            dvd1.setStudio(studio);
            dvd1.setNote(note);

            System.out.println("DVD Info Updated");

        }

    }

    private void getReleasesInLastNYears() {

        int years = io.integerPrompt("Please enter a number of years to see DVD's within that age range");

        List<Dvd> dvdList = new ArrayList<>();

        dvdList = impl.getReleasesInLastNYears(years);

        for (Dvd dvd1 : dvdList) {
            System.out.println(dvd1.getTitle());
            System.out.println(dvd1.getReleaseDate());
            System.out.println(dvd1.getMpaaRating());
            System.out.println(dvd1.getDirector());
            System.out.println(dvd1.getStudio());
            System.out.println(dvd1.getNote());
            System.out.println("");

        }

    }

    private void getByStudio() {

        String studio = io.stringPrompt("Please enter the production studio of the DVD to find");

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = impl.getByStudio(studio);

        for (Dvd dvd1 : dvdList) {

            System.out.println(dvd1.getTitle());
            System.out.println(dvd1.getReleaseDate());
            System.out.println(dvd1.getMpaaRating());
            System.out.println(dvd1.getDirector());
            System.out.println(dvd1.getStudio());
            System.out.println(dvd1.getNote());
            System.out.println("");

        }

    }

    private void getByRating() {

        String mpaaRating = io.stringPrompt("Please enter an MPAA rating to see DVD's with that rating");

        List<Dvd> dvdList = new ArrayList<>();
        dvdList = impl.getByRating(mpaaRating);

        for (Dvd dvd1 : dvdList) {

            System.out.println(dvd1.getTitle());
            System.out.println(dvd1.getReleaseDate());
            System.out.println(dvd1.getMpaaRating());
            System.out.println(dvd1.getDirector());
            System.out.println(dvd1.getStudio());
            System.out.println(dvd1.getNote());
            System.out.println("");

        }

    }

    private void writeToFile() throws IOException {

        try {
            impl.writeToFile();
            // old way---addressBook.writeAddressBook();
        } catch (IOException ioe1) {
            System.out.println("error");
        }
    }

    private void loadFromFile() throws FileNotFoundException {

        try {
            impl.loadFromFile();
            // old way---addressBook.loadAddressBook();
        } catch (IOException ioe1) {
            System.out.println("error");
        }

    }

    private void getByDirectorGroupByRating() {
        String director = io.stringPrompt("Please enter the director to see a list of his/her movies grouped by rating: ");

        //string =rating
        Map<String, List<Dvd>> dvdMap = new HashMap<>();
        dvdMap = impl.getByDirectorGroupByRating(director);

        //dvdMap is a map where keys are ratings, values are lists of DVD's
        Set myKeys = dvdMap.keySet();
        Iterator<String> iter = myKeys.iterator();

        while (iter.hasNext()) {

            String rating = iter.next();
            System.out.println("");
            System.out.println("Rating : " + rating);

            List<Dvd> dvdList = dvdMap.get(rating);
            for (Dvd dvd1 : dvdList) {
                System.out.println("");

                System.out.println(dvd1.getTitle());
                System.out.println(dvd1.getReleaseDate());
                System.out.println(dvd1.getMpaaRating());
                System.out.println(dvd1.getDirector());
                System.out.println(dvd1.getStudio());
                System.out.println(dvd1.getNote());
                System.out.println("");
//            
            }

        }

    }

    private void getAverageAge() {

        double avgAge = impl.getAverageAge();

        System.out.println("The average age of the DVD's currently in the library is: " + avgAge);

    }

}
