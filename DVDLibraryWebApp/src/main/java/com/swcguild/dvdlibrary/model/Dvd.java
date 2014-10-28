package com.swcguild.dvdlibrary.model;

import org.joda.time.LocalDate;


import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;

public class Dvd {

    private int dvdId;
    private String title;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private LocalDate releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String note;

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
 
    public long getAge() {
        LocalDate myLocalDate= LocalDate.now();
        return myLocalDate.getYear()-releaseDate.getYear();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.title);
        hash = 13 * hash + Objects.hashCode(this.releaseDate);
        hash = 13 * hash + Objects.hashCode(this.mpaaRating);
        hash = 13 * hash + Objects.hashCode(this.director);
        hash = 13 * hash + Objects.hashCode(this.studio);
        hash = 13 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

}
