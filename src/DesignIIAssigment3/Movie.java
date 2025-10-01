package DesignIIAssigment3;

import java.io.Serializable;

public class Movie extends MediaItem implements Serializable {

    private String director;
    private int year;
    private int runtimeMinutes;
    private static int idCount = 1;

    public Movie(String director, int year, int runtimeMinutes, String id, String title){
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
        super.setType("Movie");
        super.setId(getId() + idCount);
        super.setTitle(title);
        idCount++;
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

    @Override
    public void summary(){
        System.out.println("Movie Director: " + director + " Year: " + year + " Runtime Minutes: " + runtimeMinutes);
    }

    @Override
    public String CSVFormat(){
        String info = "";
        info += getType() + "," + getId() + "," + getTitle() + "," + director + "," + year + "," + runtimeMinutes;
        return info;
    }

}//end class
