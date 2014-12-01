
package DVDLibrary.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;




//to match Eric's version I changed userRatingOrNote to note and changed rating to mpaaRating


public class Dvd implements Comparable<Dvd> {

   
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String note;
    
    
    // Eric didn't use a constructor.  Do I have to???
    //if I don't use constrcutor how do I set up my tokens to load DVD library?
    
//    public Dvd  (String title, String releaseDate, String mpaaRating, String director, String studio, String note) {
//
//        this.title = title;
//        this.releaseDate = releaseDate;
//        this.mpaaRating = mpaaRating;
//        this.director = director;
//        this.studio = studio;
//        this.note = note;
//    }    
        



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
        Period p = releaseDate.until(LocalDate.now());
        return p.getYears();
    }
 
 //////////////////////////////////////////////////////////////////////////////////////////////////////   
    
     //compareTo method is called by Arrays.sort.....we don't need to call it!!
    public int compareTo(Dvd compareDVD) {

        //order by title first
        int currentCompare = this.title.compareTo(compareDVD.title);
        if (currentCompare != 0) {
            return currentCompare;
        }//then check director
        currentCompare = this.director.compareTo(compareDVD.director);
        if (currentCompare != 0) {
            return currentCompare;
        }//check rating
        currentCompare = this.mpaaRating.compareTo(compareDVD.mpaaRating);
        if (currentCompare != 0) {
            return currentCompare;
        }
        //check releaseDate
        currentCompare = this.releaseDate.compareTo(compareDVD.releaseDate);
        if (currentCompare != 0) {
            return currentCompare;
        }
        //check studio
        currentCompare = this.studio.compareTo(compareDVD.studio);
        if (currentCompare != 0) {
            return currentCompare;
        }
        //check userRatingOrNote
        //don't need if statement since it's the last one checked
        return this.note.compareTo(compareDVD.note);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.releaseDate);
        hash = 47 * hash + Objects.hashCode(this.mpaaRating);
        hash = 47 * hash + Objects.hashCode(this.director);
        hash = 47 * hash + Objects.hashCode(this.studio);
        hash = 47 * hash + Objects.hashCode(this.note);
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