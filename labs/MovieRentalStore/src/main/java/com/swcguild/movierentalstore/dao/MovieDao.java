
package com.swcguild.movierentalstore.dao;

import com.swcguild.movierentalstore.domain.Movie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public interface MovieDao {
    
   
    public void addMovie(Movie movie);
    public void deleteMovie(Movie movie);
    
    public void checkInMovie(Movie movie);
    public void checkOutMovie(Movie movie);
    
    public List<Movie> viewAllMovies();
    public List<Movie> viewByTitle(String title);
   
    public void readFile() throws FileNotFoundException, IOException; 
    public void writeFile() throws IOException; 
    
    public String encodeDates(LocalDate date);
    public LocalDate decodeDates(String placeholder);
            
    
    
}
