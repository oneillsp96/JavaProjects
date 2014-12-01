
package com.swcguild.dvdlibraryv3.dao;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrarydao.model.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DvdLibraryDaoImpl implements DvdLibraryDao {
    
    public static final String DVDLIBRARY_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";

    private List<Dvd> dvdList = new ArrayList<Dvd>();

    
    public void add(Dvd dvd) {
        dvdList.add(dvd);
    }

    public void remove(Dvd dvd) {
        dvdList.remove(dvd);
    }

    public List<Dvd> listAll(){
    return dvdList;
    
    }
           
    public List<Dvd> getByTitle(String title){
        
        return dvdList.stream()
                .filter(d->d.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        
    }
            
          
    public List<Dvd> getReleasesInLastNYears(int years) {
        
        
        //will need a prompt in the controller or prompt here?
        
        return dvdList.stream()
                .filter(d->d.getAge()< years)
                
                .collect(Collectors.toList());
    
    }
            
           
            
      public List<Dvd> getByRating(String mpaaRating) {
      
          return dvdList.stream()
          .filter(r->r.getMpaaRating().equalsIgnoreCase(mpaaRating))
                  .collect(Collectors.toList());
                
      }
            
    public List<Dvd> getByStudio(String studio){
        
    return dvdList.stream()
            .filter(s->s.getStudio().equalsIgnoreCase(studio))
            .collect(Collectors.toList());
    
    }
            
            
            
            
   //string is rating?
    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director){
        
        return dvdList.stream()
                .filter(d->d.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.groupingBy(d->d.getMpaaRating()));
        
        
//        return addressList.stream()
//                .filter(a->a.getState().equalsIgnoreCase(state))
//                .collect(Collectors.groupingBy(a->a.getCity())); 
    
    }

    public double getAverageAge() {
    
        return dvdList.stream()
                
                .mapToDouble(d->d.getAge())
                .average()
                .getAsDouble();
         
    }
            
            
   public void loadFromFile() throws FileNotFoundException {
   
    Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));

        //"bookkeeping"
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            //get the line and put it into current line
            currentLine = sc.nextLine();

            //tells it to split string on delimiter(:: in this case)
            currentTokens = currentLine.split(DELIMITER);

         //old way with constructor--   Dvd currentDVD = new Dvd(currentTokens[0], currentTokens[1], currentTokens[2], currentTokens[3], currentTokens[4], currentTokens[5]);
//no constructor this way
            
            
            
            Dvd currentDVD=new Dvd();
            
            currentDVD.setTitle(currentTokens[0]);
            LocalDate myDate = LocalDate.parse(currentTokens[1]);   
            currentDVD.setReleaseDate(myDate);
            currentDVD.setMpaaRating(currentTokens[2]);
            currentDVD.setDirector(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setNote(currentTokens[5]);
            
            
            dvdList.add(currentDVD);
         
//  old way with HashMap ----dvdMap.put(currentDVD.getTitle(), currentDVD);

        }
        sc.close();
   
   }
         
           
    public void writeToFile() throws IOException {
        
        PrintWriter out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));

        Collection<Dvd> myDVD = dvdList;   //
        Iterator<Dvd> iter2 = myDVD.iterator();

        Dvd currentDVD;
        while (iter2.hasNext()) {

            currentDVD = iter2.next();

            out.println(currentDVD.getTitle() + DELIMITER + currentDVD.getReleaseDate()
                    + DELIMITER + currentDVD.getMpaaRating() + DELIMITER + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER + currentDVD.getNote());
            out.flush();   //force write
        }

        out.close();
    }
    
}
