package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.model.Dvd;
import java.util.List;
import java.util.Map;

public interface DvdLibraryDao {

    public void addDvd(Dvd dvd);  //don't need to return dvd

    public void removeDvd(int dvdId);

    public void updateDvd(Dvd dvd);

    public List<Dvd> getAllDvds();

    public Dvd getDvdById(int dvdId);

    public List<Dvd> getByTitle(String title);

    public List<Dvd> getReleasesInLastNYears(int years);

    public List<Dvd> getByRating(String mpaaRating);

    public List<Dvd> getByStudio(String studio);

    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director);

    public long getAverageAge();  //still need to implement

}
