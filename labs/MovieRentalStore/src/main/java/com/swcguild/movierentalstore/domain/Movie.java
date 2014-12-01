package com.swcguild.movierentalstore.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Movie {

    private int movieNum;
    private String title;
    private String releaseDate;
    private String director;
    private double price;
    private String status;
    private String bluRayOrDVD;
    private String newOrClassic;
    private LocalDate checkedOutDate;
    private LocalDate dueDate;
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBluRayOrDVD() {
        return bluRayOrDVD;
    }

    public void setBluRayOrDVD(String bluRayOrDVD) {
        this.bluRayOrDVD = bluRayOrDVD;
    }

    public String getNewOrClassic() {
        return newOrClassic;
    }

    public void setNewOrClassic(String newOrClassic) {
        this.newOrClassic = newOrClassic;
    }
   
    public int getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public LocalDate getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(LocalDate CheckedOutDate) {
        this.checkedOutDate = CheckedOutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate DueDate) {
        this.dueDate = DueDate;
    }
 public int getPeriodOut() {
        Period periodOut  = checkedOutDate.until(LocalDate.now());
        return periodOut.getDays();
    }
   
    
    
    
    @Override
    public String toString(){
    return "title: " + this.title + "\nRelease Date " + this.releaseDate +"\nDirector: " + this.director;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.movieNum;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.releaseDate);
        hash = 73 * hash + Objects.hashCode(this.director);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.status);
        hash = 73 * hash + Objects.hashCode(this.bluRayOrDVD);
        hash = 73 * hash + Objects.hashCode(this.newOrClassic);
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
        final Movie other = (Movie) obj;
        if (this.movieNum != other.movieNum) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.bluRayOrDVD, other.bluRayOrDVD)) {
            return false;
        }
        if (!Objects.equals(this.newOrClassic, other.newOrClassic)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
