package DesignIIAssigment3;

public class Movie extends MediaItem{

    private String director;
    private int year;
    private int runtimeMinutes;

    public Movie(String director, int year, int runtimeMinutes, String id, String title){
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
        super.setId(id);
        super.setTitle(title);
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

}//end class
