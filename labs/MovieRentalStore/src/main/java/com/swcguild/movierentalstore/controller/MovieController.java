package com.swcguild.movierentalstore.controller;

import com.swcguild.movierentalstore.dao.MovieDao;
import com.swcguild.movierentalstore.dao.MovieNumGen;
import com.swcguild.movierentalstore.domain.Movie;
import com.swcguild.movierentalstore.ui.IO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieController {

    MovieDao dao;
    MovieNumGen mng;
    IO io;

    //add constructor to inject
    public MovieController(IO io, MovieDao dao, MovieNumGen mng) {
        this.io = io;
        this.dao = dao;
        this.mng = mng;
    }

    public void run() throws FileNotFoundException, IOException {
        String menuChoice = "";
        dao.readFile();

        do {
            menuChoice = displayMenu();

            switch (menuChoice) {
                case "1":
                    viewAllMovies();
                    break;
                case "2":
                    viewMoviesByTitle();
                    break;
                case "3":
                    checkInMovie();
                    break;
                case "4":
                    checkOutMovie();
                    break;
                case "5":
                    addMovie();
                    break;
                case "6":
                    deleteMovie();
                    break;
                case "7":
                    save();
                    break;

                case "Q":
                case "q":
                    io.print("Thank you, goodbye");
                    break;
                default:
                    io.print("invalid input-  try again");

            }

        } while (!menuChoice.equalsIgnoreCase("Q"));

    }

    private String displayMenu() {

        return io.stringPrompt("=============================\n"
                + "1. View All Movies\n"
                + "2. View Movies By Title\n"
                + "3. Check In Movie\n"
                + "4. Check Out Movie \n"
                + "5. Add Movie\n"
                + "6. Delete Movie\n"
                + "7.  Save \n"
                + "Q = Quit");

    }

    public void viewAllMovies() {

    }

    public List<Movie> viewMoviesByTitle() {

        String movieChoice = io.stringPrompt("Enter the title of the movie to find");

        List<Movie> tempList = new ArrayList<>();
        tempList = dao.viewByTitle(movieChoice);

        for (Movie movie1 : tempList) {

            movie1.getMovieNum();
            movie1.getTitle();
            movie1.getReleaseDate();
            movie1.getDirector();
            movie1.getPrice();
            movie1.getStatus();
            movie1.getBluRayOrDVD();
            movie1.getNewOrClassic();

            io.print(movie1.toString());

        }
        return tempList;
    }

    public void checkInMovie() throws IOException {

        //load inventory here and put it in movieList
        List<Movie> movieList = new ArrayList<>();

        movieList = dao.viewByTitle(io.stringPrompt("Please enter the title you'd like to check in"));
        if (movieList != null && movieList.size() == 1) {
            Movie movieX = new Movie();
            movieX = movieList.get(0);

            io.print("Thank you for renting: " + movieX.getTitle());

            double totalCost;
            int daysLate = 0;

            if (LocalDate.now().isAfter(movieX.getDueDate())) {
                daysLate = (movieX.getPeriodOut() - 2);                    //controller should not talk to dto!!!  fix this tomorrow

                totalCost = movieX.getPrice() + (1 * daysLate);
                io.print("This movie was " + daysLate + " days late");
                io.print("The movie price was: " + movieX.getPrice());
                io.print("A late fee of " + (1 * daysLate) + " has been assesed");
                io.print("Total cost: " + totalCost);
            } else {
                totalCost = movieX.getPrice();
                io.print("You returned on time.  Total Cost: " + movieX.getPrice() );
            }

            dao.checkInMovie(movieX);
            dao.writeFile();
            io.print("check-in successful");

        } else if (movieList
                == null) {
            io.print("invalid selection");
            //enter code to handle invalid selection/multiple titles

        }

    }

    public void checkOutMovie() throws IOException {

        //load inventory here and put it in movieList
        List<Movie> movieList = new ArrayList<>();

        movieList = dao.viewByTitle(io.stringPrompt("Please enter the title you'd like to check out"));
        if (movieList != null && movieList.size() == 1) {
            Movie movieX = new Movie();
            movieX = movieList.get(0);
            io.print("You selected: " + movieX.getTitle());

            dao.checkOutMovie(movieX);
            dao.writeFile();
            io.print("checkout successful");

        } else if (movieList == null) {
            io.print("invalid selection");

            //enter code here to handle invalid selection (do-while loop?) / multiple titles
        }

    }

    public void addMovie() throws FileNotFoundException, IOException {

        Movie movie1 = new Movie();
        double price = 0;

        movie1.setTitle(io.stringPrompt("Enter the title of the movie you would like to add"));
        movie1.setDirector(io.stringPrompt("Enter the director"));
        movie1.setReleaseDate(io.stringPrompt("Enter the release date"));
        movie1.setStatus("CheckedIn");
        int classicOrNew = io.intBetweenPrompt("Enter 1 for classic or 2 for new release", 1, 2);
        if (classicOrNew == 1) {
            price = 2.25;
            movie1.setNewOrClassic("Classic");

        } else if (classicOrNew == 2) {

            movie1.setNewOrClassic("New Release");
            price = 4.95;
        }

        int BluRayOrDVD = io.intBetweenPrompt("Please enter 1 for Blu-Ray or 2 for DVD", 1, 2);

        if (BluRayOrDVD == 1) {

            movie1.setBluRayOrDVD("BluRay");

            price += 1.50;
        } else if (BluRayOrDVD == 2) {

            movie1.setBluRayOrDVD("DVD");

        }

        movie1.setPrice(price);

        movie1.setMovieNum(mng.movieNumGen());

        dao.addMovie(movie1);

        dao.writeFile();

    }

    public void deleteMovie() throws IOException {

        String movieChoice = io.stringPrompt("Enter the title of the movie you'd like to remove");
        List<Movie> tempList = new ArrayList<>();
        tempList = dao.viewByTitle(movieChoice);

        if (tempList.size() > 1) {
            for (int i = 0; i < tempList.size(); i++) {

                Movie movieX = tempList.get(i);
                System.out.println("Number: " + i);

//                    System.out.println(movieX.getMovieNum());
                System.out.println(movieX.getTitle());
                System.out.println(movieX.getReleaseDate());
                System.out.println(movieX.getDirector());
                System.out.println(movieX.getPrice());
                System.out.println(movieX.getStatus());
                System.out.println(movieX.getBluRayOrDVD());
                System.out.println(movieX.getNewOrClassic());
                System.out.println("");

            }
            //min is 0, max is size of list minus 1
            int userInput = io.intBetweenPrompt("Please enter the number of the DVD you would like to remove", 0, (tempList.size() - 1));

            dao.deleteMovie(tempList.get(userInput));

        } else if (tempList.size() == 1) {
            tempList.remove(tempList.get(0));
        }

        dao.writeFile();

        io.print("Movie Removed");

    }

    public void save() throws IOException {

        dao.writeFile();
        io.print("Movie info saved");

    }

}
