
package com.swcguild.movierentalstore.dao;

import com.swcguild.movierentalstore.domain.Movie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;


public class MovieNumGenImpl implements MovieNumGen {
    
     private int movieNum;
    Date date1 = new Date();
    Movie movie = new Movie();


    public String MOVIE_ID = "MovieNum.txt";
    public String DELIMITER = ",";

    @Override
    public int movieNumPlus() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(MOVIE_ID)));

            String number = sc.nextLine();
            movieNum = Integer.parseInt(number);
            movieNum++;
            
            return movieNum;
    }

    @Override
    public int movieNumGen() throws FileNotFoundException, IOException {
       
         File myFile = new File(MOVIE_ID);
        
        
        if (myFile.exists()) {
            
            Scanner sc = new Scanner(new BufferedReader(new FileReader(MOVIE_ID)));

            String number = sc.nextLine();
            movieNum = Integer.parseInt(number);
            movieNum++;
            PrintWriter out = new PrintWriter(new FileWriter(MOVIE_ID));

        out.println(movieNum);

        out.flush();

        out.close();
    
        

        } else {
            movieNum = 1;
            PrintWriter out = new PrintWriter(new FileWriter(MOVIE_ID));
       
            out.println(movieNum);
  
            out.flush();
            out.close();
        }

        return movieNum;
        
        
        
    }
    
     @Override
    public void movieNumWrite() throws IOException {
       PrintWriter out = new PrintWriter(new FileWriter(MOVIE_ID));

        out.println(movieNum);

        out.flush();

        out.close();
    }
    
}
