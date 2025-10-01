package DesignIIAssigment3;

import java.io.Serializable;

public class Book extends MediaItem implements Serializable {

    private String author;
    private int year;
    private int pageCount;
    private static int idCount = 1;

    public Book(String author, int year, int pageCount, String title){
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
        super.setType("Book");
        super.setTitle(title);
        super.setId(getId() + idCount);
        idCount++;
    }

    public Book(String author, int year, int pageCount, int id, String type, String title){
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
        super.setId(id);
        super.setType(type);
        super.setTitle(title);
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
