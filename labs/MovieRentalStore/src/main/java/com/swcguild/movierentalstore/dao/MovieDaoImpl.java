
package com.swcguild.movierentalstore.dao;

import com.swcguild.movierentalstore.domain.Movie;
import com.swcguild.movierentalstore.ui.IO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MovieDaoImpl implements MovieDao{
IO io;
MovieDao dao;


 Date date = new Date();
    Movie movie = new Movie();
    private ArrayList<Movie> movieList = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String file = "Order_" + dateFormat.format(date) + ".txt";
    public String MOVIE_FILE = file;
    public String DELIMITER = ",";
    
    
    @Override
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
         movieList.remove(movie);
    }

    @Override
    public void checkInMovie(Movie movie) {
        
        movie.setStatus("CheckedIn");
        movie.setCheckedOutDate(null);
        movie.setDueDate(null);
        
 // put stuff dealing with getPeriod here
        }
        
     

    @Override
    public void checkOutMovie(Movie movie) {
        
        movie.setCheckedOutDate(LocalDate.now());
        movie.setDueDate(LocalDate.now().plusDays(2));
        movie.setStatus("CheckedOut");
        
        
           
    }

    @Override
    public List<Movie> viewAllMovies() {
         io.print("viewing all");
         
         return null;
    }

    @Override
    public List<Movie> viewByTitle(String title) {
         
         
          return movieList.stream()
                .filter(movies->movies.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        
    }

    @Override
    public void readFile() throws FileNotFoundException, IOException {
        
         File myFile = new File(MOVIE_FILE);
        if (myFile.exists()) {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(MOVIE_FILE)));
            String currentLine;
            String[] token;
            movieList.clear();

            while (sc.hasNextLine()) {

                currentLine = sc.nextLine();
                token = currentLine.split(DELIMITER);

                Movie movieX=new Movie();
                movieX.setMovieNum(Integer.parseInt(token[0]));
                movieX.setTitle(token[1]);
                movieX.setReleaseDate(token[2]);
                movieX.setDirector(token[3]);
                movieX.setPrice(Double.parseDouble(token[4]));
                movieX.setStatus(token[5]);
                movieX.setBluRayOrDVD(token[6]);
                movieX.setNewOrClassic(token[7]);
                movieX.setCheckedOutDate(decodeDates(token[8]));
                movieX.setDueDate(decodeDates(token[8]));
                
      //this is a major source of bugs - converting from string in text file to local date and vice versa
                
                


                
                
                if (movieX.getTitle().contains("-")) {
                    movieX.setTitle(movieX.getTitle().replace("-", ","));
                }
               movieList.add(movieX);
            }
            sc.close();
        } else {
            PrintWriter out = new PrintWriter(new FileWriter(MOVIE_FILE));

        }
        
    }

    @Override
    public void writeFile() throws IOException {
      
        PrintWriter out = new PrintWriter(new FileWriter(MOVIE_FILE));
        Iterator<Movie> iter = movieList.iterator();

        while (iter.hasNext()) {
            Movie movieX = iter.next();
        if (movieX.getTitle().contains(",")) {
                movieX.setTitle(movieX.getTitle().replace(",", "-"));
            }
            out.println(movieX.getMovieNum() + DELIMITER
                    + movieX.getTitle() + DELIMITER
                    + movieX.getReleaseDate() + DELIMITER
                    + movieX.getDirector() + DELIMITER
                    + movieX.getPrice() + DELIMITER
                    + movieX.getStatus() + DELIMITER
                    + movieX.getBluRayOrDVD() + DELIMITER
                    + movieX.getNewOrClassic() + DELIMITER
                    + encodeDates(movieX.getCheckedOutDate()) + DELIMITER
                    + encodeDates(movieX.getDueDate()) );                    ///is this legit?
             
        }
        out.flush();

        out.close();
    }
    
    
    @Override
    public String encodeDates(LocalDate date) {
        String placeholder;
        if (date == null) {
            placeholder = "~";
        } else {
            placeholder = date.toString();
        }
        return placeholder;

    }

    @Override
    public LocalDate decodeDates(String placeholder) {
        LocalDate date = null;
        if (placeholder.equals("~")) {
            date = null;
        } else {
            date = LocalDate.parse(placeholder);
        }
        return date;
    }

      
        
     
        
        
    
    
}
