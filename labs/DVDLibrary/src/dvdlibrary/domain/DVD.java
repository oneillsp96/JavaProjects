package dvdlibrary.domain;

import java.util.Objects;

public class DVD implements Comparable<DVD> {

    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String userRatingOrNote;

    public DVD(String title, String releaseDate, String rating, String director, String studio, String userRatingOrNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.director = director;
        this.studio = studio;
        this.userRatingOrNote = userRatingOrNote;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public String getUserRatingOrNote() {
        return userRatingOrNote;
    }

    public void setUserRatingOrNote(String userRatingOrNote) {
        this.userRatingOrNote = userRatingOrNote;
    }

     //compareTo method is called by Arrays.sort.....we don't need to call it!!
    public int compareTo(DVD compareDVD) {

        //order by title first
        int currentCompare = this.title.compareTo(compareDVD.title);
        if (currentCompare != 0) {
            return currentCompare;
        }//then check director
        currentCompare = this.director.compareTo(compareDVD.director);
        if (currentCompare != 0) {
            return currentCompare;
        }//check rating
        currentCompare = this.rating.compareTo(compareDVD.rating);
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
        return this.userRatingOrNote.compareTo(compareDVD.userRatingOrNote);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.releaseDate);
        hash = 47 * hash + Objects.hashCode(this.rating);
        hash = 47 * hash + Objects.hashCode(this.director);
        hash = 47 * hash + Objects.hashCode(this.studio);
        hash = 47 * hash + Objects.hashCode(this.userRatingOrNote);
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
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userRatingOrNote, other.userRatingOrNote)) {
            return false;
        }
        return true;
    }

}
