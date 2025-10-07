package DesignIIAssigment3;

import java.io.Serializable;

/**
 * Book class, inherits from MediaItem and implements Serializable.
 */
public class Book extends MediaItem implements Serializable {

    /**
     * Standard Strings and integer values for the author, year, and page count.
     * Static int for the id Count. Keeps track of how many books have been instantiated for unique
     * id numbers.
     */
    private String author;
    private int year;
    private int pageCount;
    private static int idCount = 1;


    public Book(String author, int year, int pageCount, String title){
        super("B" + idCount, title, "Book");
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
        idCount++;
    }

    public Book(String author, int year, int pageCount, String id, String title, String type){
        super(id, title, type);
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    public int getIdCount(){
        return idCount;
    }

    public void setIdCount(int idCount){
        if(idCount > -1)
            Book.idCount = idCount;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(!author.isEmpty())
            this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 0)
            this.year = year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if(pageCount > 0)
            this.pageCount = pageCount;
    }

    @Override
    public void summary(){
        System.out.println("Book Author: " + author + " Year: " + year + " PageCount: " + pageCount);
    }

    @Override
    public String CSVFormat(){
        String info = "";
        info += getType() + "," + getId() + "," + getTitle() + "," + author + "," + year + "," + pageCount;
        return info;
    }
}// end class
