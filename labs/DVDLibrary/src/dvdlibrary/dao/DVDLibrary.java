package dvdlibrary.dao;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import dvdlibrary.domain.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DVDLibrary {

    public static final String DVDLIBRARY_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";

    HashMap<String, DVD> dvdMap = new HashMap<>();
    //DVD object, DVD variable

    public DVD addDVD(String title, DVD dvd) {

        return dvdMap.put(title, dvd);
    }

    public DVD removeDVD(String title) {

        return dvdMap.remove(title);
    }

    public DVD findDVD(String title) {

        return dvdMap.get(title);
    }

    public DVD[] findAll() {

        Collection<DVD> values = dvdMap.values();
        DVD[] dvdArray = values.toArray(new DVD[0]);

        return dvdArray;

    }

    public void loadDVDLibrary() throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));

        //"bookkeeping"
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            //get the line and put it into current line
            currentLine = sc.nextLine();

            //tells it to split string on delimiter(:: in this case)
            currentTokens = currentLine.split(DELIMITER);

           DVD currentDVD = new DVD(currentTokens[0], currentTokens[1], currentTokens[2], currentTokens[3], currentTokens[4], currentTokens[5]);

            
            
            
            
           dvdMap.put(currentDVD.getTitle(), currentDVD);

        }
        sc.close();

    }

    public void writeDVDLibrary() throws IOException {
//named the printwriter out and set it up

        PrintWriter out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));

        Collection<DVD> myDVD = dvdMap.values();   //
        Iterator<DVD> iter2 = myDVD.iterator();

        DVD currentDVD;
        while (iter2.hasNext()) {

            currentDVD = iter2.next();

            out.println(currentDVD.getTitle() + DELIMITER + currentDVD.getReleaseDate()
                    + DELIMITER + currentDVD.getRating() + DELIMITER + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER + currentDVD.getUserRatingOrNote());
            out.flush();   //force write
        }

        out.close();
    }

}
