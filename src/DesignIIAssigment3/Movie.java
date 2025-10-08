package DesignIIAssigment3;

import java.io.Serializable;

/**
 * Movie class, extends MediaItem, implements Serializable
 */
public class Movie extends MediaItem implements Serializable {

    /**
     * String and integer values for director, year, and runtimeMinutes
     * Static integer for idCount for unique ids.
     */
    private String director;
    private int year;
    private int runtimeMinutes;
    private static int idCount = 1;

    public Movie(String director, int year, int runtimeMinutes, String title){
        super("M" + idCount, title, "Movie");
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
        idCount++;
    }

    public Movie(String director, int year, int runtimeMinutes, String id, String title, String type){
        super(id, title, type);
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
    }

    public int getIdCount(){
        return idCount;
    }

    public void setIdCount(int idCount){
        if(idCount > -1)
            Movie.idCount = idCount;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if(!director.isEmpty())
            this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 0)
            this.year = year;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        if(runtimeMinutes > 0)
            this.runtimeMinutes = runtimeMinutes;
    }

    /**
     * Overridden summary method.
     */
    @Override
    public void summary(){
        System.out.println("Movie Director: " + director + " Year: " + year + " Runtime Minutes: " + runtimeMinutes);
    }

    /**
     * Overridden CSVFormat method.
     * @return - returns string of information in CSV format.
     */
    @Override
    public String CSVFormat(){
        String info = "";
        info += getType() + "," + getId() + "," + getTitle() + "," + director + "," + year + "," + runtimeMinutes;
        return info;
    }

}//end class
