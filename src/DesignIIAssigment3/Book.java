package DesignIIAssigment3;

public class Book extends MediaItem{

    private String author;
    private int year;
    private int pageCount;

    public Book(String author, int year, int pageCount, String id, String title){
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
        super.setId(id);
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
}// end class
