package DesignIIAssigment3;

import java.io.Serializable;

/**
 * Album class, extends MediaItem, implements Serializable
 */
public class Album extends MediaItem implements Serializable {

    /**
     * String and integer values for artist, year, and track count.
     * Static integer for idCount to keep track of unique id numbers.
     */
    private String artist;
    private int year;
    private int trackCount;
    private static int idCount = 1;

    public Album(String artist, int year, int trackCount, String title){
        super("A" + idCount, title, "Album");
        this.artist = artist;
        this.year = year;
        this.trackCount = trackCount;
        idCount++;
    }
    public Album(String artist, int year, int trackCount, String id, String title, String type){
        super(id, title, type);
        this.artist = artist;
        this.year = year;
        this.trackCount = trackCount;
    }


    public int getIdCount(){
        return idCount;
    }

    public void setIdCount(int idCount){
        if(idCount > -1)
            Album.idCount = idCount;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if(!artist.isEmpty())
            this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 0)
            this.year = year;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        if(trackCount > 0)
            this.trackCount = trackCount;
    }

    /**
     * Overridden summary method.
     */
    @Override
    public void summary(){
        System.out.println("Album Artist: " + artist + " Year: " + year + " Track Count: " + trackCount + " Title: " + getTitle());
    }

    /**
     * Overridden CSVFormat method.
     * @return - returns a string of information in csv format.
     */
    @Override
    public String CSVFormat(){
        String info = "";
        info += getType() + "," + getId() + "," + getTitle() + "," + artist + "," + year + "," + trackCount + "\n";
        return info;
    }
}//end class
