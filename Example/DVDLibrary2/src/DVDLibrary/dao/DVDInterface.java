
package DVDLibrary.dao;

import DVDLibrary.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface DVDInterface {
    
    public interface DvdLibraryDao {
    
    public void add(Dvd dvd);
    public void remove(Dvd dvd);
    public List<Dvd> listAll();
    public List<Dvd> getByTitle(String title);
    public List<Dvd> getReleasesInLastNYears(int years);
    public List<Dvd> getByRating(String mpaaRating);
    public List<Dvd> getByStudio(String studio);
    
    
    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director);
    public double getAverageAge();
    public void loadFromFile() throws FileNotFoundException;
    public void writeToFile() throws IOException;
    
}
    
}
